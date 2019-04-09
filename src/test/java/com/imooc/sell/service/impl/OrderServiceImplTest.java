package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        orderDTO.setBuyerName("包子烦恼_1");
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

    @Test
    public void findOne() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1554705333635446416");
        OrderDTO serviceOne = orderService.findOne(orderDTO);
        Assert.assertNotNull(serviceOne);
        Assert.assertNotNull(serviceOne.getOrderDetails());
        Assert.assertNotEquals(0, serviceOne.getOrderDetails().size());
    }

    @Test
    public void findList() {
        PageRequest p = new PageRequest(1, 3);
        Page<OrderDTO> page = orderService.findList("steamed-bun", p);
        Assert.assertNotEquals(0, page.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1554705427018214338");
        OrderDTO serviceOne = orderService.findOne(orderDTO);
        OrderDTO cancel = orderService.cancel(serviceOne);
        Assert.assertNotNull(cancel);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL.getCode(), cancel.getOrderStatus());
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}