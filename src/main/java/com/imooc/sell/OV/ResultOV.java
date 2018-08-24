package com.imooc.sell.OV;

import lombok.Data;

/**
 * @description: http返回最外层结果
 * @author: WangXue
 * @create: 2018-07-26 16:30
 */
@Data
public class ResultOV<T> {

    private Integer code;
    private String msg;
    private T data;

}
