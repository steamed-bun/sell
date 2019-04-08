package com.imooc.sell.utils;

import java.util.Random;

/**
 * @description: 生成数据库key
 * @author: WangXue
 * @create: 2019-04-03 16:22
 */
public class KeyUtil {

    /**
     *  生成唯一主键
     *  时间加上随机数
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
