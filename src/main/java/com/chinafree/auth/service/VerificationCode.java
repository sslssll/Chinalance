package com.chinafree.auth.service;

import com.chinafree.common.model.response.BaseResponse;

public interface VerificationCode {
    BaseResponse sendRegisterVerificationCode(String name, String phoneNumber);

    void checkVerificationCode(String name, String phoneNumber, String Vertifivation);
}
