package com.chinafree.auth.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class SysLoginLog {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String loginName;

    private Integer loginType;

    private Integer loginPlatform;

    private Integer loginIp;

    @TableField( fill = FieldFill.INSERT)
    private Date loginDateTime;

    private Integer loginFlag;

}