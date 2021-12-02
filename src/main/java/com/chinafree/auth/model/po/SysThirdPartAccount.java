package com.chinafree.auth.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysThirdPartAccount {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long loginId;

    private String openId;

    private String thirdPartyAccountType;

}