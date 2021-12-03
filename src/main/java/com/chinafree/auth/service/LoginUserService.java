package com.chinafree.auth.service;


import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.po.SysLoginUser;
import com.chinafree.auth.model.po.SysThirdPartAccount;
import com.chinafree.auth.model.result.ThirdPartAccountResult;
import com.chinafree.common.base.BaseService;
import com.chinafree.common.model.response.BaseResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional(readOnly = false)
public interface LoginUserService  extends BaseService<SysLoginUser,Long> {
    //根据邮箱获取用户信息
    LoginUserBo getLoginUserByLoginMail(String loginMail);
    //根据手机获取用户信息
    LoginUserBo getLoginUserByLoginMobile(String loginMobile);
    //修改密码
    void modifyPasswordByPhone(Long LoginUserId, String password);



}
