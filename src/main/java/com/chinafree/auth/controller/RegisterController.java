package com.chinafree.auth.controller;

import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.service.RegisterService;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/register")
@Api(produces = "application/json", tags = "RegisterController", description = "注册接口")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/sendRegisterVerificationCode")
    public BaseResponse sendRegisterVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
      return registerService.sendRegisterVerificationCode(phoneNumber);
    }
    /**
     * 注册成功后，直接登录
     * 手机号直接做用户名
     * @return
     */
    @PostMapping("/registerByPhoneAndCode")
    public BaseResponse registerByPhoneAndCode(@RequestBody RequestParameter<RegistrationParam> registrationParam){
        registerService.registerByPhoneAndCode(registrationParam.getBody());
        return new BaseResponse(ResponseCodeEnum.SUCCESS,"注册成功");
    }

}
