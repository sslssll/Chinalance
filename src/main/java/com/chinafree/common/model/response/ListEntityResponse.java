package com.chinafree.common.model.response;

import com.chinafree.common.model.enumeration.BaseCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 列表返回类型
 *
 * @author chuansongcao
 */
@Data
@NoArgsConstructor
public class ListEntityResponse<T, E> extends AbstractResponse {
    private ListEntityResponseData<T, E> data;

    public ListEntityResponse(BaseCodeEnum code, String message, List<T> data, E entity) {
        super(code, message);
        this.data = new ListEntityResponseData<>(data, entity);
    }

    @JsonIgnore
    public List<T> getResponseData() {
        return getData().getList();
    }

    @JsonIgnore
    public E getResponseEntityData() {
        return getData().getEntity();
    }
}
