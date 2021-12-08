package com.chinafree.auth.service;

import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.common.model.response.BaseResponse;

public interface RegisterService {

    //发送注册验证码
    BaseResponse sendRegisterVerificationCode(String phoneNumber);

    //根据手机和验证码注册
    LoginResult registerByPhoneAndCode(RegistrationParam body);
}
