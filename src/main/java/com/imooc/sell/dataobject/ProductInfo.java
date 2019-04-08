package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @description: 商品信息
 * @author WangXue
 * @create: 2018-07-26 16:08
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品所属类目 */
    private Integer categoryType;
    /** 商品图标 */
    private String productIcon;
    /** 商品描述 */
    private String productDescription;
    /** 商品状态 */
    private int productStatus;

}
