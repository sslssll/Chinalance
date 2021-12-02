package com.chinafree.common.model.request;//package com.chinafree.common.model.request;
//
//
//import com.chinafree.common.model.enumeration.SortOrderEnum;
//import com.chinafree.common.model.info.ResultInfo;
//import com.chinafree.common.util.model.PageRunner;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.SuperBuilder;
//
///**
// * 分页器参数
// *
// * @author : Sonya
// * @date : 2020/3/23 19:29
// */
//@Data
//@SuperBuilder
//@AllArgsConstructor
//@NoArgsConstructor
//public class ListPagingPagerParam<T, R, E, P extends ListPagingParam> {
//    /**
//     * 默认分页参数
//     */
//    public static final Integer DEFAULT_PAGE_SIZE = PageRunner.PAGE_SIZE;
//    /**
//     * 默认方法名 统计
//     */
//    public static final String DEFAULT_COUNT_METHOD_NAME = "countByParam";
//    /**
//     * 默认方法名 获取上个页面最后一个指定值
//     */
//    public static final String DEFAULT_LAST_VAL_METHOD_NAME = "fetchLastValByParamAndLastVal";
//    /**
//     * 默认方法名 获取最后一页数据
//     */
//    public static final String DEFAULT_LIST_METHOD_NAME = "listByParamAndLastVal";
//
//
//    /**
//     * Mapper.class
//     */
//    private T mapper;
//    /**
//     * 查询参数
//     */
//    private P queryParam;
//    /**
//     * xxxPO.class
//     */
//    private Class<R> poClazz;
//    /**
//     * @see ListPagingPagerParam#DEFAULT_COUNT_METHOD_NAME
//     */
//    private String countMethodName = DEFAULT_COUNT_METHOD_NAME;
//    /**
//     * @see ListPagingPagerParam#DEFAULT_LAST_VAL_METHOD_NAME
//     */
//    private String lastValMethodName = DEFAULT_LAST_VAL_METHOD_NAME;
//    /**
//     *
//     */
//    private String pageByParam = "pageByParam";
//    /**
//     * @see ListPagingPagerParam#DEFAULT_LIST_METHOD_NAME
//     */
//    private String listMethodName = DEFAULT_LIST_METHOD_NAME;
//    /**
//     * 根据某field排序
//     */
//    private E fieldEnum;
//    /**
//     * desc / asc
//     */
//    private SortOrderEnum orderByDirection = SortOrderEnum.DESC;
//    /**
//     * 业务.分页大小
//     */
//    private Integer pageSize = DEFAULT_PAGE_SIZE;
//
//    public ListPagingPagerParam(T mapper, Class<R> poClazz, E fieldEnum, P queryParam) {
//        this.setMapper(mapper);
//        this.setPoClazz(poClazz);
//        this.setQueryParam(queryParam);
//        this.setFieldEnum(fieldEnum);
//    }
//
//    public ResultInfo<String> checkParams() {
//        if (mapper == null) {
//            return ResultInfo.error("mapper，必填");
//        }
//        if (fieldEnum == null) {
//            return ResultInfo.error("排序字段枚举，必填");
//        }
//        if (poClazz == null) {
//            return ResultInfo.error("返回的po类型，必填");
//        }
//        if (queryParam == null) {
//            return ResultInfo.error("查询参数，必填");
//        }
//        return ResultInfo.success();
//    }
//}
