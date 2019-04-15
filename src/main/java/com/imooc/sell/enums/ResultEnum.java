package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @description: 提示信息
 * @author: WangXue
 * @create: 2019-04-03 16:11
 */
@Getter
public enum  ResultEnum {
    PRODUCT_NOT_ENOUGH(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态错误"),
    ORDER_UPDATE_ERROR(15, "订单更新失败"),
    TIME_OUT_WISH(16, "时间范围超出预期"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
