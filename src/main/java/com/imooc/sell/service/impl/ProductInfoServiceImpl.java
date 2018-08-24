package com.imooc.sell.service.impl;

import com.imooc.sell.Repository.ProductInfoRepository;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 商品信息处理
 * @author: WangXue
 * @create: 2018-07-26 15:03
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    @Autowired
    public ProductInfoServiceImpl(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
