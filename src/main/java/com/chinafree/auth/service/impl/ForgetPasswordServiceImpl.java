package com.chinafree.auth.service.impl;

import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.service.ForgetPasswordService;
import com.chinafree.auth.service.LoginUserService;
import com.chinafree.auth.service.VerificationCode;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.response.BaseResponse;
import com.google.common.base.VerifyException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

    @Autowired
    private VerificationCode verificationCode;

    @Autowired
    private LoginUserService loginUserService;

    private final String FORGET_PASSWORD = "FORGET_PASSWORD_";

    @Override
    public BaseResponse sendRegisterVerificationCode(String phoneNumber) {
        return verificationCode.sendRegisterVerificationCode(FORGET_PASSWORD,phoneNumber);
    }

    @Override
    public BaseResponse resetPassword(RegistrationParam registrationParam) {
        String phoneNumber = registrationParam.getPhoneNumber();
        String verification = registrationParam.getVerification();
        String password = registrationParam.getPassword();
        if(StringUtils.isEmpty(phoneNumber)){
            throw new VerifyException("没有填写手机号");
        }
        if(StringUtils.isEmpty(verification)){
            throw new VerifyException("没有填写验证码");
        }
        if(StringUtils.isEmpty(password)){
            throw new VerifyException("没有填写密码");
        }
        verificationCode.checkVerificationCode(FORGET_PASSWORD,phoneNumber,verification);
        LoginUserBo loginUserByLoginMobile = loginUserService.getLoginUserByLoginMobile(phoneNumber);
        Long id = loginUserByLoginMobile.getId();
        loginUserService.modifyPasswordByPhone(id,password);
        return new BaseResponse(ResponseCodeEnum.SUCCESS,"更新成功");
    }
}
