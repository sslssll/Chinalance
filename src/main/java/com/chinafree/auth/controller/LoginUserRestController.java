package com.chinafree.auth.controller;

import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.LoginService;


import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.BaseResponse;
import com.chinafree.common.model.response.EntityResponse;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2018/8/24 14:33
 */
@RestController
@RequestMapping("/login")
@Api(produces = "application/json",tags = "LoginUserRestController",description="登录接口")
public class LoginUserRestController extends BaseController {
    private static final String EMAIL_LOGIN_URL = "/normal/login";
    private static final String SHORT_MESSAGE_LOGIN_URL = "/short/message/login";
    private static final String THIRD_PART_LOGIN_URL = "/third/part/login";

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "redirect:main.html";
    }


    @ApiOperation(value="正常登录" , notes = "邮箱和手机+密码登录")
    @RequestMapping(value = EMAIL_LOGIN_URL, method = RequestMethod.POST)
    public EntityResponse<LoginResult> emailLogin(@RequestBody RequestParameter<LoginParam> request) {
        LoginParam loginParam = request.getBody();
        LoginResult loginResult = loginService.loginByUsernameAndPwd(loginParam);
        return new EntityResponse<>(ResponseCodeEnum.SUCCESS,"登录成功",loginResult);
    }


    @ApiOperation(value="正常登录" , notes = "发送登录验证码")
    @RequestMapping(value = "sendLoginVerfication", method = RequestMethod.POST)
    public BaseResponse sendLoginVerfication(@RequestParam("phoneNumber") String phoneNumber) {
        return loginService.sendRegisterVerificationCode(phoneNumber);
    }



    @ApiOperation(value="正常登录" , notes = "手机+验证码登录")
    @RequestMapping(value = SHORT_MESSAGE_LOGIN_URL, method = RequestMethod.POST)
    public EntityResponse<LoginResult> LoginByPhoneAndVerfication(@RequestBody RequestParameter<LoginParam> request) {
        LoginParam loginParam = request.getBody();
        LoginResult loginResult = loginService.LoginByPhoneAndVerfication(loginParam);
        return new EntityResponse<>(ResponseCodeEnum.SUCCESS,"登录成功",loginResult);
    }

}
