package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("孤独");
        productCategory.setCategoryType(40);
        ProductCategory category = categoryService.save(productCategory);
        Assert.assertNotNull(category);
    }

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(3);
        Assert.assertEquals(new Integer(3),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categories = categoryService.findAll();
        Assert.assertNotEquals(0, categories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(0, categories.size());
    }
}