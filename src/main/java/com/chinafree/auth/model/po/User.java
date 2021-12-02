package com.chinafree.auth.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class User extends BaseEntity{

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private Long loginUserId;

    private String realname;

    private String area;

    private String images;

    private Date birthday;


}
