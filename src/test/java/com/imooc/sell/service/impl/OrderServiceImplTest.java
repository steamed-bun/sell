package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("包子烦恼");
        orderDTO.setBuyerAddress("桃花岛");
        orderDTO.setBuyerOpenid("steamed-bun");
        orderDTO.setBuyerPhone("88888888");
        List<OrderDetail> orderDetailList = new ArrayList<>(2);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(3);
        orderDetailList.add(orderDetail);
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("1234567");
        orderDetail1.setProductQuantity(3);
        orderDetailList.add(orderDetail1);
        orderDTO.setOrderDetails(orderDetailList);

        orderService.create(orderDTO);

    }
}