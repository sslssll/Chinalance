package com.chinafree.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chuansongcao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingParam {
    public static final PagingParam DEFAULT_PAGING = new PagingParam(0, 1000);
    public static final PagingParam MAX_PAGING = new PagingParam(0, 8000);
    /**
     * start
     */
    private Integer start;
    /**
     * length
     */
    private Integer length;
}
