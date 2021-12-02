package com.chinafree.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinafree.auth.exception.BusinessException;
import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.model.po.SysLoginUser;
import com.chinafree.auth.model.po.User;
import com.chinafree.auth.service.RegisterService;
import com.chinafree.auth.service.VerificationCode;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.response.BaseResponse;
import com.chinafree.common.utils.MD5Utils;
import com.chinafree.mapper.SysLoginUserMapper;
import com.chinafree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private VerificationCode verificationCode;

    @Autowired
    private SysLoginUserMapper sysLoginUserMapper;

    @Autowired
    private UserMapper userMapper;

    final static String REGISTER_VERIFICATION = "REGISTER_VERIFICATION";

    @Override
    public BaseResponse sendRegisterVerificationCode(String phoneNumber) {
        return verificationCode.sendRegisterVerificationCode(REGISTER_VERIFICATION,phoneNumber);
    }


    @Override
    public void registerByPhoneAndCode(RegistrationParam body) {
        //1.校验验证码
        if(body.getPhoneNumber()==null){
            throw new BusinessException(ResponseCodeEnum.FORBIDDEN.toString(),"未填写手机号");
        }
        verificationCode.checkVerificationCode(REGISTER_VERIFICATION,body.getPhoneNumber(),body.getVerification());
        //2.快速注册（插入数据库）
        createUser(body);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    void createUser(RegistrationParam body) {

        SysLoginUser build = SysLoginUser.builder()
                .loginMobile(body.getPhoneNumber())
                .password(body.getPassword()==null?null:MD5Utils.hash(body.getPassword()))
                .build();
        SysLoginUser sysLoginUser = sysLoginUserMapper.selectOne(new QueryWrapper<SysLoginUser>().eq("login_mobile", body.getPhoneNumber()));
        if(sysLoginUser!=null){
            throw new BusinessException(ResponseCodeEnum.FORBIDDEN.toString(),"手机号已注册");
        }

        long loginUserId = sysLoginUserMapper.insert(build);
        SysLoginUser sysLoginUser1 = sysLoginUserMapper.selectOne(new QueryWrapper<SysLoginUser>().eq("login_mobile", body.getPhoneNumber()));


        User user = User.builder().username(body.getPhoneNumber()).loginUserId(sysLoginUser1.getId()).build();
        long userId = userMapper.insert(user);

//        SysLoginRef loginRef = SysLoginRef.builder()
//                .loginId(id)
//                .userId(id)
//                .build();
//        sysLoginRefMapper.insert(loginRef);
    }
}
