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
class ListPagingEntityResponseData<T, E> extends ListPagingResponseData<T> {
    private E entity;

    public ListPagingEntityResponseData(List<T> data, E entity, Integer start, Integer length, Integer recordsTotal) {
        super(data, start, length, recordsTotal);
        this.entity = entity;
    }
}
