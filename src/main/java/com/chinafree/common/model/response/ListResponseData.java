package com.chinafree.common.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chuansongcao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
class ListResponseData<T> extends AbstractResponseData {
    /**
     * 列表数据
     */
    private List<T> list;

    public ListResponseData(List<T> list) {
        this.list = list;
    }
}
