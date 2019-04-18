package com.imooc.sell.controller;

import com.imooc.sell.OV.ResultOV;
import com.imooc.sell.converter.OrderFormToOrderDTOConverter;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.ResultOVUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 买家订单
 * @author: WangXue
 * @create: 2019-04-18 10:46
 */
@Slf4j
@RestController
@RequestMapping(value = "/buy/order")
public class BuyOrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public ResultOV<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("创建订单，参数不正确，orderForm={]", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("创建订单，购物车不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
        orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", orderDTO.getOrderId());
        return ResultOVUtil.success(map);
    }
    //订单列表
    //订单详情
    //取消订单

}
