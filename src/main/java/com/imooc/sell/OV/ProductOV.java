package com.imooc.sell.OV;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 商品列表返回
 * @author: WangXue
 * @create: 2018-07-26 16:32
 */
@Data
public class ProductOV {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoOV> productInfoOVList;

}
