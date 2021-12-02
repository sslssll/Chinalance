package com.chinafree.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author chuansongcao
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ListPagingParam {
    /**
     * 分页参数
     */
    private PagingParam pagingParam;
}
