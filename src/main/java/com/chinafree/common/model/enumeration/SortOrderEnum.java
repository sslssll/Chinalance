package com.chinafree.common.model.enumeration;

/**
 * @author : Sonya
 * @date : 2020/3/23 19:30
 */
public enum SortOrderEnum {
    /**
     * 升序
     */
    ASC("asc"),
    /**
     * 降序
     */
    DESC("desc");

    private String id;

    SortOrderEnum(String id) {
        this.id = id;
    }

    public static SortOrderEnum parseById(String id) {
        for (SortOrderEnum sortOrderEnum : SortOrderEnum.values()) {
            if (sortOrderEnum.getId().equals(id)) {
                return sortOrderEnum;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }
}
