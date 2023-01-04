package com.hb.payment.enums;


import com.hb.core.enums.BaseEnum;
import lombok.Getter;

/**
 * @author zhaochengshui
 * @description 订单状态枚举类
 * @date 2022/11/22
 */
@Getter
public enum OrderStatusEnum implements BaseEnum {
    OK(0, "成功"),
    WAIT(1, "等待支付"),
    CLOSE(2, "订单关闭"),
    BACK(3, "回退");



    public Integer code;
    public String desc;

     OrderStatusEnum(int code ,String desc){
        this.code = code;
        this.desc = desc;
    }

}
