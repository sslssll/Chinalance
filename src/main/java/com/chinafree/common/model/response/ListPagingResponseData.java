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
class ListPagingResponseData<T> extends ListResponseData<T> {
    /**
     * 分页参数, 起始位置
     */
    private Integer start;
    /**
     * 分页参数，每页容量
     */
    private Integer length;
    /**
     * 分页结果，总筛选数量
     */
    private Integer recordsTotal;

    public ListPagingResponseData(List<T> data, Integer start, Integer length, Integer recordsTotal) {
        super(data);
        this.start = start;
        this.length = length;
        this.recordsTotal = recordsTotal;
    }
}
