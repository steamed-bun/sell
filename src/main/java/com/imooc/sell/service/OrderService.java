package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @description: 订单处理
 * @author: WangXue
 * @create: 2019-04-03 15:50
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单 */
    OrderDTO findOne(OrderDTO orderDTO);

    /** 查询订单列表 */
    List<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finsh(OrderDTO orderDTO);

    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
