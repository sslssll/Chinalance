package com.chinafree.auth.model.result;

import lombok.Data;

@Data
public class ThirdPartAccountResult extends BaseResult {
    private String openId;
    private String thirdPartyAccountType;
    private Long id;
}
