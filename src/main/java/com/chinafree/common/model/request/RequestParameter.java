package com.chinafree.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 请求参数封装
 *
 * @author chuansongcao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestParameter<T> {
    /**
     * 请求参数封装
     */
//    @Valid
//    @NotNull
    private T body;

    public void setBody(T body) {
        this.body = body;
    }
}
