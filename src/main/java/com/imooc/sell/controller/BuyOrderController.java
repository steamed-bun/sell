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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    @GetMapping(value = "/list")
    public ResultOV<List<OrderDTO>> list(String openid,
                                         @RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】出错，openid为null");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        return ResultOVUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping(value = "/detail")
    public ResultOV<OrderDTO> detail(@RequestParam String orderId) {
        //todo 安全问题
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultOVUtil.success(orderDTO);
    }
    //取消订单
}
