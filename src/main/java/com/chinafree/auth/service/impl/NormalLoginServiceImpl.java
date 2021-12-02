package com.chinafree.auth.service.impl;

import com.chinafree.auth.exception.BusinessException;
import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.po.SysLoginLog;
import com.chinafree.auth.model.po.User;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.model.result.ThirdPartAccountResult;
import com.chinafree.auth.service.LoginUserService;
import com.chinafree.auth.service.NormalLoginService;

import com.chinafree.common.base.HttpStatus;
import com.chinafree.common.utils.MD5Utils;
import com.chinafree.common.utils.RegexUtils;
import com.chinafree.mapper.SysLoginLogMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class NormalLoginServiceImpl implements NormalLoginService {

    private static long PASSWORD_EFFECTIVE_TIME = 15 * 60;
    private static long TOKEN_EFFECTIVE_TIME = 100000000 * 60 * 60;
    public static String LOGIN_TIMES_PREFIX = "LOGIN_TIMES_";
    public static String TOKEN = "LG_";

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    public LoginResult login(String loginMail, String password) {

        //1. 从数据库获取loginUser
        LoginUserBo loginUserBo = queryLoginUser(loginMail);

        //2.判断密码是否正确,错误超多5次就冻结
        checkPassword(loginMail, password, loginUserBo);

        //3.构造loginResult
        LoginResult result = getLoginResult(loginUserBo);

        //4.构造登录日志
        SysLoginLog build = SysLoginLog.builder()
                .loginName(result.getUserId().toString())
                .build();
        sysLoginLogMapper.insert(build);
        return result;

    }

    @Override
    public LoginResult getLoginResult(LoginUserBo loginUserBo) {
//        SysLoginRef sysLoginRef = loginUserBo.getSysLoginRef();
        final User user = loginUserBo.getUser();
        if (user == null) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "user为空");
        }

        Map<String,Long> map = new HashMap<>();
        map.put("loginId", loginUserBo.getId());
        map.put("userId",user.getId());

        LoginResult result = new LoginResult();
        result.setLoginId(loginUserBo.getId());
        result.setLoginUserType(loginUserBo.getLoginUserType());
        result.setUserId(user.getId());
        //////////设置一个token







        //将loginId和userId存入redis中
        redisTemplate.opsForValue().set(TOKEN +result.getToken(),map,2, TimeUnit.HOURS);
        return result;
    }

    /**
     * 判断密码是否正确,错误超多5次就冻结
     * @param loginMail
     * @param password
     * @param loginUserBo
     */
    private void checkPassword(String loginMail, String password, LoginUserBo loginUserBo) {
        //密码输入错误次数
        String loginTimes = "0";
        BoundValueOperations redisWrongTimes = redisTemplate.boundValueOps(LOGIN_TIMES_PREFIX + loginMail);
        String s = (String) redisWrongTimes.get();
        boolean empty = StringUtils.isEmpty((String) redisWrongTimes.get());
        if(StringUtils.isEmpty((String)redisWrongTimes.get())){
            if(StringUtils.isEmpty(loginUserBo.getPassword())){
                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"您未设置密码!!");
            }
            //错误密码记录不存在,验证用户密码是否正确
            if (!loginUserBo.getPassword().equals(MD5Utils.hash(password))) {
                //密码错误,向redis插入错误密码的记录,提示密码错误
                redisWrongTimes.set( loginTimes, PASSWORD_EFFECTIVE_TIME);
                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误");
            }
        }else {
            //错误密码记录存在,就获取错误次数
            Integer cLoginTime = (Integer)redisWrongTimes.get();
            if (cLoginTime < 5) {
                //错误次数不到5次,可以继续验证用户密码是否正确
                if (!loginUserBo.getPassword().equals(MD5Utils.hash(password))) {
                    //密码错误,错误次数+1并存入redis,提示密码错误
                    redisWrongTimes.set(String.valueOf(cLoginTime+1),PASSWORD_EFFECTIVE_TIME);
                    throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误");
                }
            } else {
                //错误次数达到5次,冻结用户,提示：输入密码错误超过5次请稍后重试
                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "输入密码错误超过5次，请稍后重试");
            }
        }
    }


    /**
     *  从数据库获取loginUser
     * @param loginMail
     * @return
     */
    private LoginUserBo queryLoginUser(String loginMail) {
        LoginUserBo loginUserbo;
        //判断loginMail是邮箱
        if (RegexUtils.checkMail(loginMail)) {
            //根据邮箱获取用户
            loginUserbo = loginUserService.getLoginUserByLoginMail(loginMail);
        } else if (RegexUtils.checkMobile(loginMail)) {
            //根据手机号获取用户
            loginUserbo = loginUserService.getLoginUserByLoginMobile(loginMail);
        } else {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "邮箱或手机格式不正确");
        }
        if (loginUserbo == null) {
            //用户不存在
            //throw new NotFindLoginUserException();
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "用户不存在！");
        }
        return loginUserbo;

    }


}