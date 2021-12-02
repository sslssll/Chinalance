package com.chinafree.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 应用层分页器返回数据
 *
 * @author : Sonya
 * @date : 2020/3/23 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPagingPagerData<T> {
    public static final ListPagingPagerData EMPTY = new ListPagingPagerData<>(0, Collections.emptyList());

    /**
     * 数据统计
     */
    private Integer count;
    /**
     * 分页数据
     */
    private List<T> pagedData;
}
