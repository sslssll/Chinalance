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
    private Long loginId;
    private Integer loginUserType;
    private String userType;
    private Long userId;
    private boolean isRegister;
    private String token;
    private List<ThirdPartAccountResult> thirdPartAccountResults;
}
