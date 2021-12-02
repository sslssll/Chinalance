package com.chinafree.auth.service;

import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.common.model.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResult loginByUsernameAndPwd(LoginParam body);

    LoginResult LoginByPhoneAndVerfication(LoginParam loginParam);

    BaseResponse sendRegisterVerificationCode(String phone);
}
