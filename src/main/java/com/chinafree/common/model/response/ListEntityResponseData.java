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
class ListEntityResponseData<T, E> extends ListResponseData<T> {
    /**
     * 列表数据
     */
    private E entity;

    public ListEntityResponseData(List<T> list, E entity) {
        super(list);
        this.entity = entity;
    }
}
