package com.chinafree.common.model.response;


import com.chinafree.common.model.enumeration.BaseCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 列表分页返回类型
 *
 * @author chuansongcao
 */
@Data
@NoArgsConstructor
public class ListPagingResponse<T> extends AbstractResponse {
    private ListPagingResponseData<T> data;

    public ListPagingResponse(BaseCodeEnum code, String message, List<T> data, Integer start, Integer length, Integer recordsTotal) {
        super(code, message);
        this.data = new ListPagingResponseData<>(data, start, length, recordsTotal);
    }

    @JsonIgnore
    public List<T> getResponseData() {
        return getData().getList();
    }

    @JsonIgnore
    public Integer getResponseRecordsTotal() {
        return getData().getRecordsTotal();
    }
}
