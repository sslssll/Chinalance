package com.chinafree.auth.service.impl;

import com.chinafree.auth.exception.BusinessException;
import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.po.SysLoginLog;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.LoginService;
import com.chinafree.auth.service.LoginUserService;
import com.chinafree.auth.service.NormalLoginService;
import com.chinafree.auth.service.VerificationCode;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.response.BaseResponse;
import com.chinafree.mapper.SysLoginLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private NormalLoginService normalLoginService;

    @Autowired
    private VerificationCode verificationCode;


    private final static String LOGIN = "LOGIN";

    @Override
    public LoginResult loginByUsernameAndPwd(LoginParam normalLoginParam) {
        String loginName = normalLoginParam.getUsername();
        String password = normalLoginParam.getPassword();
        LoginResult result = normalLoginService.login(loginName, password);
        return result;
    }

    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public LoginResult LoginByPhoneAndVerfication(LoginParam loginParam) {
        if (loginParam.getUsername() == null || loginParam.getPassword() == null) {
            throw new BusinessException(ResponseCodeEnum.FORBIDDEN.toString(), "手机或验证码没写");
        }
        verificationCode.checkVerificationCode(LOGIN, loginParam.getUsername(), loginParam.getPassword());
        LoginUserBo loginUserByLoginMobile = loginUserService.getLoginUserByLoginMobile(loginParam.getUsername());
        LoginResult loginResult = normalLoginService.getLoginResult(loginUserByLoginMobile);
        //日志
        SysLoginLog build = SysLoginLog.builder()
                .loginName(loginResult.getUserId().toString())
                .build();
        sysLoginLogMapper.insert(build);
        return loginResult;
    }

    @Override
    public BaseResponse sendRegisterVerificationCode(String phone) {
        return verificationCode.sendRegisterVerificationCode(LOGIN, phone);
    }


}