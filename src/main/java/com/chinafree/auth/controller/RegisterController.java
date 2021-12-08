package com.chinafree.auth.controller;

import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.RegisterService;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.BaseResponse;
import com.chinafree.common.model.response.EntityResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("login/register")
@Api(produces = "application/json", tags = "RegisterController", description = "注册接口")
public class RegisterController extends BaseController{

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value="发送注册验证码" , notes = "发送注册验证码")
    @PostMapping("/sendRegisterVerificationCode")
    public BaseResponse sendRegisterVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
      return registerService.sendRegisterVerificationCode(phoneNumber);
    }

    @ApiOperation(value="发送注册验证码注册" , notes = "发送注册验证码注册")
    @PostMapping("/registerByPhoneAndCode")
    public EntityResponse<LoginResult> registerByPhoneAndCode(@RequestBody RequestParameter<RegistrationParam> registrationParam){
        LoginResult loginResult = registerService.registerByPhoneAndCode(registrationParam.getBody());
        return new EntityResponse<>(ResponseCodeEnum.SUCCESS,"注册成功",loginResult);
    }

}
