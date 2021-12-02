package com.chinafree.common.model.exception;

import com.chinafree.common.model.enumeration.BaseEnum;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum HttpMethodEnum implements BaseEnum {
    /**
     * http method
     */
    GET(1, "GET"),
    POST(2, "POST"),
    PUT(3, "PUT"),
    DELETE(4, "DELETE");

    private int id;

    private String method;

    HttpMethodEnum(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public static HttpMethodEnum parseByMethod(String method) {
        for (HttpMethodEnum httpMethodEnum : HttpMethodEnum.values()) {
            if (StringUtils.equalsIgnoreCase(httpMethodEnum.getMethod(), method)) {
                return httpMethodEnum;
            }
        }
        return null;
    }

    @Override
    public int getValue() {
        return this.id;
    }
}
