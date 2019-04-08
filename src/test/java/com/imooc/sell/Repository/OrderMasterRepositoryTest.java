package com.imooc.sell.Repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Resource
    private OrderMasterRepository repository;

    private static final String OPENI_ID = "wxOpenid";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("wx");
        orderMaster.setBuyerAddress("陕西省_2");
        orderMaster.setBuyerName("王雪");
        orderMaster.setBuyerOpenid(OPENI_ID);
        orderMaster.setBuyerPhone("18829289582");
        orderMaster.setOrderAmount(new BigDecimal(2.43));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(1, 3);
        Page<OrderMaster> repository = this.repository.findByBuyerOpenid(OPENI_ID, request);
        Assert.assertNotNull(repository);

    }
}