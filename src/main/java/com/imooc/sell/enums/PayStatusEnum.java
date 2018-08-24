package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @description: 付费状态
 * @author: WangXue
 * @create: 2018-08-23 17:06
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
