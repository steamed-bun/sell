package com.imooc.sell.Repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("冰红茶");
        productInfo.setProductPrice(new BigDecimal(11.2));
        productInfo.setProductDescription("戒不掉呀");
        productInfo.setProductIcon(".....");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        productInfo.setProductStock(1000);
        ProductInfo productInfo1 = repository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, byProductStatus.size());
    }
}