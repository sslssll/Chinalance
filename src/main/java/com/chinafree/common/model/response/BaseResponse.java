package com.chinafree.common.model.response;

import com.chinafree.common.model.enumeration.BaseCodeEnum;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import lombok.NoArgsConstructor;

/**
 * 基础http返回信息
 *
 * @author chuansongcao
 */
@NoArgsConstructor
public class BaseResponse extends AbstractResponse {
    private static final BaseResponse SUCCESS = new BaseResponse(ResponseCodeEnum.SUCCESS, "成功");

    public BaseResponse(BaseCodeEnum code, String message) {
        super(code, message);
    }

    public static BaseResponse success() {
        return SUCCESS;
    }
}
