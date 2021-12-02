package com.chinafree.common.model.response;

import com.chinafree.common.model.enumeration.BaseCodeEnum;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽象的http返回信息
 *
 * @author chuansongcao
 */
@Data
@NoArgsConstructor
public abstract class AbstractResponse {
    /**
     * 请求处理状态
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String message;


    public AbstractResponse(BaseCodeEnum responseCodeEnum, String message) {
        this.code = responseCodeEnum.getCode();
        this.message = message;
    }

    @JsonIgnore
    public boolean isResponseRight() {
        return code.equals(ResponseCodeEnum.SUCCESS.getCode());
    }
}
