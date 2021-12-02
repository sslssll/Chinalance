package com.chinafree.auth.service;

import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.common.model.response.BaseResponse;

public interface RegisterService {

    BaseResponse sendRegisterVerificationCode(String phoneNumber);

    void registerByPhoneAndCode(RegistrationParam body);
}
