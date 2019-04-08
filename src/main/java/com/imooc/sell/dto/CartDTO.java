package com.imooc.sell.dto;

import lombok.Data;

/**
 * @description: 购物车接收消息
 * @author: WangXue
 * @create: 2019-04-03 17:11
 */
@Data
public class CartDTO {

    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
