package com.imooc.sell.controller;

import com.imooc.sell.OV.ProductOV;
import com.imooc.sell.OV.ResultOV;
import com.imooc.sell.Repository.OrderMasterRepository;
import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.utils.ResultOVUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: aaa
 * @author: WangXue
 * @create: 2019-01-22 15:02
 */
@RestController
@RequestMapping(value = "/postman")
public class TestController {

    @Resource
    private OrderMasterRepository repository;

    @PostMapping(value = "/first")
    public ResultOV first() {
        ProductOV productOV = new ProductOV();
        productOV.setCategoryName("图书");
        productOV.setCategoryType(1);
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("wx");
        orderMaster.setBuyerAddress("陕西省_1");
        orderMaster.setBuyerName("王雪");
        orderMaster.setBuyerOpenid("wxOpenid");
        orderMaster.setBuyerPhone("18829289582");
        orderMaster.setOrderAmount(new BigDecimal(2.43));
        repository.save(orderMaster);
        return ResultOVUtil.success(productOV);
    }

    @PostMapping(value = "/second")
    public ResultOV second(ProductOV productOV) {

        return ResultOVUtil.success();
    }

    @PostMapping(value = "/third")
    public ResultOV third(String sign) {
        System.out.println(sign);
        return ResultOVUtil.success();
    }

    @PostMapping(value = "/fourth")
    public ResultOV fourth(String name, Integer age, Double money) {
        System.out.println(name + "的年龄是" + age +"，有" + money + "存款");
        return ResultOVUtil.success();
    }

    private static final Pattern PATTER = Pattern.compile("bonus.....([0-9]+\\.[0-9]+)");

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File csv = new File("/Users/steamed-bun/Downloads/lottery_award_remember_cny4.csv");
        BufferedWriter out =new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/steamed-bun/Downloads/cny4.csv"),"UTF-8"));
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line;
        String everyLine;
        Matcher matcher;
        String group;
        BigDecimal bonus;
        try {
            while ((line = br.readLine()) != null)
            {
                bonus = new BigDecimal(0);
                everyLine = line;
                matcher = PATTER.matcher(everyLine);
                while (matcher.find()) {
                    group = matcher.group(1).replace("\"\"", "\"");
                    bonus = bonus.add(new BigDecimal(Double.parseDouble(group)));
                }
                everyLine = everyLine + "," + bonus.doubleValue();
                out.write(everyLine);
                out.write(",");
                out.newLine();
            }
            out.flush();
            out.close();
            br.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
