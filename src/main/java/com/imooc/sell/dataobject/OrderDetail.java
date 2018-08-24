package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 订单详情
 * @author: WangXue
 * @create: 2018-08-23 17:11
 */
@Entity
@DynamicUpdate
@Data
public class OrderDetail {

    @Id
    private String detailId;
    private Integer orderId;
    private Integer productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;
    private Date createTime;
    private Date updateTime;


}
