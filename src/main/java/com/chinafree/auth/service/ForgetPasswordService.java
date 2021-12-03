package com.chinafree.auth.service;

import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.common.model.response.BaseResponse;

public interface ForgetPasswordService {

    BaseResponse sendRegisterVerificationCode( String phoneNumber);

    BaseResponse resetPassword(RegistrationParam registrationParam);
}
