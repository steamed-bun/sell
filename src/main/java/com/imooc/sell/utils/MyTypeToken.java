package com.imooc.sell.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @description: 测试获取带具体泛型list的type
 * @author: WangXue
 * @create: 2019-04-18 15:01
 */
public abstract class MyTypeToken<T> {

    private final Type type;

    protected MyTypeToken() {
        //同Gson的Type需写成protected 不实例化则会出错
        Type superclass = getClass().getGenericSuperclass();
        //由于采用了abstract类,并且将构造方法写成了protected，故不会出现这种情况
        /*
        if(superclass instanceof Class){
            throw new RuntimeException("Missing type parameter.");
        }
        */
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        type = actualTypeArguments[0];
    }

    public Type getType() {
        return type;
    }

    public static void main(String[] args) {
        MyTypeToken<List<String>> myTypeToken = new MyTypeToken<List<String>>(){};
        System.out.println(myTypeToken);
    }

}
