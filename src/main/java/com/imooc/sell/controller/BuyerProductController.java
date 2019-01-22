package com.imooc.sell.controller;

import com.imooc.sell.OV.ProductInfoOV;
import com.imooc.sell.OV.ProductOV;
import com.imooc.sell.OV.ResultOV;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductInfoService;
import com.imooc.sell.utils.ResultOVUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 买家商品
 * @author: WangXue
 * @create: 2018-07-26 16:51
 */
@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    private final ProductInfoService productInfoService;

    private final CategoryService categoryService;

    @Autowired
    public BuyerProductController(ProductInfoService productInfoService, CategoryService categoryService) {
        this.productInfoService = productInfoService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/list")
    public ResultOV list() {
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        List<Integer> typeList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(typeList);
        List<ProductOV> productOVS = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductOV productOV = new ProductOV();
            productOV.setCategoryName(productCategory.getCategoryName());
            productOV.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoOV> productInfoOVS = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoOV productInfoOV = new ProductInfoOV();
                    BeanUtils.copyProperties(productInfo, productInfoOV);
                    productInfoOVS.add(productInfoOV);
                }
            }
            productOV.setProductInfoOVList(productInfoOVS);
            productOVS.add(productOV);
        }
        return ResultOVUtil.success(productOVS);
    }


    @GetMapping(value = "/test")
    public ResultOV test() {
        return ResultOVUtil.success("test");
    }

}
