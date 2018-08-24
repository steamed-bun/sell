package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertNotNull(productInfo);

    }

    @Test
    public void findUpAll() {
        List<ProductInfo> all = productInfoService.findUpAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0, all.getTotalElements());
    }

}