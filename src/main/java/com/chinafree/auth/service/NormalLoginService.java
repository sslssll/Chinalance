package com.chinafree.auth.service;

import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.result.LoginResult;
import org.springframework.stereotype.Service;

@Service
public interface NormalLoginService {


    LoginResult login(String loginMail, String password);

    LoginResult getLoginResult(LoginUserBo loginUserBo);
}
