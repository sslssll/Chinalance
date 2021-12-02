package com.chinafree.common.model.enumeration;

import lombok.Getter;

import java.util.Objects;


@Getter
public enum OnOffEnum implements BaseEnum {
    /**
     * 开启
     */
    ON(1, "是", true),
    /**
     * 关闭
     */
    OFF(0, "否", false);

    /**
     * 标志位
     */
    private int onOrOff;

    /**
     * 描述
     */
    private String desc;

    /**
     * boolean值
     */
    private Boolean booleanValue;

    OnOffEnum(int onOrOff, String desc, Boolean booleanValue) {
        this.onOrOff = onOrOff;
        this.desc = desc;
        this.booleanValue = booleanValue;
    }

    public static OnOffEnum parseByValue(int onOrOff) {
        for (OnOffEnum onOffEnum : OnOffEnum.values()) {
            if (onOffEnum.getOnOrOff() == onOrOff) {
                return onOffEnum;
            }
        }
        return null;
    }

    public static OnOffEnum parseByDesc(String desc) {
        for (OnOffEnum onOffEnum : OnOffEnum.values()) {
            if (Objects.equals(onOffEnum.desc, desc)) {
                return onOffEnum;
            }
        }
        return null;
    }

    @Override
    public int getValue() {
        return onOrOff;
    }
}
