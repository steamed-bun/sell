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
    PRODUCT_STOCK_ERROR(11, "商品库存不足");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
