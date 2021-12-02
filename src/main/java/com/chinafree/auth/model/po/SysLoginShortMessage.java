package com.chinafree.auth.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysLoginShortMessage {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String loginId;

    private String loginMobile;

    private String verificationCode;

    private String status;

    private Long sendDateTime;

    private Long endDateTime;

    private String shortMessageType;


}