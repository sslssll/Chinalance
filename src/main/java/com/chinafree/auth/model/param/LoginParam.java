package com.chinafree.auth.model.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginParam extends BaseParam{

    private String username;

    private String password;

}
