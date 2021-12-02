package com.chinafree.common.model.info;

import lombok.Data;

@Data
public class ResultInfo<T> {
    /**
     * 结果是否正确
     */
    private boolean isRight;
    /**
     * 信息
     */
    private String message;
    /**
     * 对象
     */
    private T data;

    public ResultInfo(boolean isRight, String message, T data) {
        this.isRight = isRight;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultInfo<T> success(T data) {
        return new ResultInfo<>(true, "succeed", data);
    }

    public static <T> ResultInfo<T> success() {
        return new ResultInfo<>(true, "succeed", null);
    }

    public static <T> ResultInfo<T> error(String message) {
        return new ResultInfo<>(false, message, null);
    }

    public static <T> ResultInfo<T> error(String message, T data) {
        return new ResultInfo<>(false, message, data);
    }
}
