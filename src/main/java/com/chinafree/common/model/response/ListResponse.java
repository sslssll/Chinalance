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
public class ListResponse<T> extends AbstractResponse {
    private ListResponseData<T> data;

    public ListResponse(BaseCodeEnum code, String message, List<T> data) {
        super(code, message);
        this.data = new ListResponseData<>(data);
    }

    @JsonIgnore
    public List<T> getResponseData() {
        return getData().getList();
    }
}
