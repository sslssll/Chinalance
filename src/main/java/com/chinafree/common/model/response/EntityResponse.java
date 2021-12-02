package com.chinafree.common.model.response;

import com.chinafree.common.model.enumeration.BaseCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类型返回类型
 *
 * @author chuansongcao
 */
@NoArgsConstructor
@Data
public class EntityResponse<T> extends AbstractResponse {
    private EntityResponseData<T> data;

    public EntityResponse(BaseCodeEnum code, String message, T data) {
        super(code, message);
        this.data = new EntityResponseData<>(data);
    }

    @JsonIgnore
    public T getResponseData() {
        return getData().getEntity();
    }
}
