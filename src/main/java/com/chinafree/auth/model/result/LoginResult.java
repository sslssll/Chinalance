package com.chinafree.auth.model.result;

import lombok.*;

import java.util.List;


/**
 * 用户登录返回值
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginResult extends BaseResult {
    //login id
    private Long loginId;
    //用户类型
    private String userType;
    //用户id
    private Long userId;
    //用户名
    private String userName;
    //token
    private String token;





    //    private Integer loginUserType;
//    private boolean isRegister;


//    private List<ThirdPartAccountResult> thirdPartAccountResults;
}
