package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @description: 订单状态
 * @author: WangXue
 * @create: 2018-08-23 17:00
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "取消"),
    ;

    /**
     * 订单状态
     */
    private Integer code;
    /**
     * 订单状态描述
     */
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
