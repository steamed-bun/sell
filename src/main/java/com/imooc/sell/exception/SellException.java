package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * @description: 售卖异常
 * @author: WangXue
 * @create: 2019-04-03 16:09
 */
public class SellException extends RuntimeException{

    private Integer code;
    private Object data;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(ResultEnum resultEnum, Object data) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.data = data;
    }
}
