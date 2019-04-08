package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo save(ProductInfo productInfo);

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    /** 获取所有上架的商品 */
    List<ProductInfo> findUpAll();

    /** 加库存 */

    void increaseStock(List<CartDTO> cartDTOS);

    /** 减库存 */
    void decreaseStock(List<CartDTO> cartDTOS);

}
