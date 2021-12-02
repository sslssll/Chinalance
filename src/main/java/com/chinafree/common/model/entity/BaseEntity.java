package com.chinafree.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 租户id
     */
    private String tenantId;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(String tenantId) {
        this.tenantId = tenantId;
    }
}
