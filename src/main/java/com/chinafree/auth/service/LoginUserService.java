package com.chinafree.auth.service;


import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.po.SysLoginUser;
import com.chinafree.auth.model.po.SysThirdPartAccount;
import com.chinafree.auth.model.result.ThirdPartAccountResult;
import com.chinafree.common.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional(readOnly = false)
public interface LoginUserService  extends BaseService<SysLoginUser,Long> {
    //根据邮箱获取用户信息
    LoginUserBo getLoginUserByLoginMail(String loginMail);
    //根据手机获取用户信息
    LoginUserBo getLoginUserByLoginMobile(String loginMobile);
    //根据userId查询第三方信息
    List<ThirdPartAccountResult>  getThirdPartAccountByLoginId(Long loginId);


//    //根据OpenId获取用户信息
//    LoginUser getLoginUserByOpenId(String openId, String thirdPartAccountType);
//    //计算该邮箱登录的用户个数
//    int countByLoginMail(String loginMail);
//    //计算该手机号码登录的用户个数
//    int countByLoginMobile(String loginMobile);
//    //修改密码
//    void modifyPassword(String loginId, String password);


}
