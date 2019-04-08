package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @description: 商品状态
 * @author WangXue
 * @create: 2018-07-26 16:08
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1, "下架"),
    ;

    /**
     * 商品状态
     */
    private Integer code;
    /**
     * 商品状态描述
     */
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
