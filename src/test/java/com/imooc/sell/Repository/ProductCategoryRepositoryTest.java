package com.imooc.sell.Repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void test() {
        ProductCategory productCategory = productCategoryRepository.findOne(3);
        productCategory.setCategoryName("baby01");
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> categoryTypeList = Arrays.asList(1,2,3);
        List<ProductCategory> categoryList = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotNull(categoryList);
    }

}