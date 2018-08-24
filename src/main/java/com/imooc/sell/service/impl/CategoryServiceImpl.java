package com.imooc.sell.service.impl;

import com.imooc.sell.Repository.ProductCategoryRepository;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes) {
        return categoryRepository.findByCategoryTypeIn(categoryTypes);
    }
}
