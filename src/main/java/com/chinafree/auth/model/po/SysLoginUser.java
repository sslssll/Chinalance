package com.chinafree.auth.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class SysLoginUser extends BaseEntity{

    @TableId(type = IdType.AUTO)
    private Long id;

    private String loginName;

    private String loginMobile;

    private String loginMail;

    private String password;

    private String loginStatus;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String lastLoginDevice;

}