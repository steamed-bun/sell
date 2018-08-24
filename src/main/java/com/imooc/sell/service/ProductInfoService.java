package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo save(ProductInfo productInfo);

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 获取所有上架的商品
     */
    List<ProductInfo> findUpAll();

}
