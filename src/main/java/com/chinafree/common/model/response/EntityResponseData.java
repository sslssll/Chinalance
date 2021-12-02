package com.chinafree.common.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chuansongcao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
class EntityResponseData<T> extends AbstractResponseData {
    /**
     * 实体类型封装
     */
    private T entity;

    public EntityResponseData(T entity) {
        this.entity = entity;
    }
}
