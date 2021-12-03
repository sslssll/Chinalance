package com.chinafree.auth.controller;


import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.ForgetPasswordService;
import com.chinafree.auth.service.LoginUserService;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.BaseResponse;
import com.chinafree.common.model.response.EntityResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forgetPassword")
public class ForgetPasswordController extends BaseController {

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private ForgetPasswordService forgetPasswordService;



    @ApiOperation(value="找回密码" , notes = "发送找回密码的验证码")
    @PostMapping("/sendForgetPasswordVerification")
    public BaseResponse sendForgetPasswordVerification(@RequestParam("phone") String phoneNumber){
        return forgetPasswordService.sendRegisterVerificationCode(phoneNumber);
    }



    @ApiOperation(value="找回密码" , notes = "手机验证码找回密码")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public BaseResponse findPwdByPhoneVerification(@RequestBody RequestParameter<RegistrationParam> request) {
        RegistrationParam registrationParam = request.getBody();
        return forgetPasswordService.resetPassword(registrationParam);
    }



}
