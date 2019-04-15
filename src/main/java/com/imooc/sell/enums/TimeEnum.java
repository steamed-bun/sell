package com.imooc.sell.enums;

import com.imooc.sell.exception.SellException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 时间段
 * @author: WangXue
 * @create: 2019-04-15 10:03
 */
@Getter
public enum TimeEnum {

    FIRST(0, 7, "第一个时间段"),
    SECEND(8, 19, "第二个时间段"),
    THIRD(20, 23, "第三个时间段"),
    ;

    /** 开始时间 */
    private Integer start;
    /** 结束时间 */
    private Integer end;
    /** 时间段说明 */
    private String msg;

    private static Map<Integer, TimeEnum> TIME_ENUM_MAP = new HashMap<>(24);

    static {
        for (TimeEnum timeEnum : TimeEnum.values()) {
            for (int i = timeEnum.start; i <= timeEnum.end; i++) {
                TIME_ENUM_MAP.put(i, timeEnum);
            }
        }
    }

    /**
     * 根据当前小时获得对应的enum
     * @param time 当前小时
     * @return 对应的enum
     */
    public static TimeEnum getTimeEnumBuyTime(Integer time) {
        if (time == null) {
            throw new SellException(ResultEnum.TIME_OUT_WISH);
        }
        TimeEnum timeEnum = TIME_ENUM_MAP.get(time);
        if (timeEnum == null) {
            throw new SellException(ResultEnum.TIME_OUT_WISH);
        }
        return timeEnum;
    }

    TimeEnum(Integer start, Integer end, String msg) {
        this.start = start;
        this.end = end;
        this.msg = msg;
    }
}
