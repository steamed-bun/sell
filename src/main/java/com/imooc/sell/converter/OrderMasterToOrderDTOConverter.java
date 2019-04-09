package com.imooc.sell.converter;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: OrderMaster 转 OrderDTO
 * @author: WangXue
 * @create: 2019-04-08 15:37
 */
public class OrderMasterToOrderDTOConverter {

    private static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters.stream().map(OrderMasterToOrderDTOConverter::convert).collect(Collectors.toList());
    }

}
