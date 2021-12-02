package com.chinafree.auth.model.bo;


import com.chinafree.auth.model.po.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@ToString
@AllArgsConstructor
public class LoginUserBo {
    //loginId
    private Long id;
    private String loginName;
    private String loginMobile;
    private String loginMail;
    private String password;
    private String loginStatus;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private String lastLoginDevice;
    private Integer loginUserType;
    //user
    private User user;
}
