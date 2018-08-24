package com.imooc.sell.utils;

import com.imooc.sell.OV.ResultOV;

/**
 * @description: 结果返回封装工具
 * @author: WangXue
 * @create: 2018-08-15 17:52
 */
public class ResultOVUtil {

    public static ResultOV success(Object o) {
        ResultOV resultOV = new ResultOV<>();
        resultOV.setData(o);
        resultOV.setCode(0);
        resultOV.setMsg("成功");
        return resultOV;
    }

    public static ResultOV success() {
        return success(null);
    }

    public static ResultOV error(Integer code, String msg) {
        ResultOV resultOV = new ResultOV<>();
        resultOV.setCode(code);
        resultOV.setMsg(msg);
        return resultOV;
    }

}
