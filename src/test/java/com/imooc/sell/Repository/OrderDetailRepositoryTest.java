package com.imooc.sell.Repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    private static final String OPENI_ID = "wxOpenid";

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2222");
        orderDetail.setOrderId(OPENI_ID);
        orderDetail.setProductId("123456");
        orderDetail.setProductIcon("icon");
        orderDetail.setProductPrice(new BigDecimal(2.5));
        orderDetail.setProductQuantity(3000);
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId(OPENI_ID);
        Assert.assertNotNull(byOrderId);
        Assert.assertNotEquals(0, byOrderId.size());
    }
}