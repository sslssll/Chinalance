package com.chinafree.common.model.authotiry;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginInfo {
    /**
     * 员工id
     */
    private Long staffId;
    /**
     * 租户id
     */
    private String tenantId;
    // 网关生成的uuid
    private String requestId;

}
