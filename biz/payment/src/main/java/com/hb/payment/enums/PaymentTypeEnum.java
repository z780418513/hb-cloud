package com.hb.payment.enums;

import com.hb.core.enums.BaseEnum;
import lombok.Getter;

/**
 * @author zhaochengshui
 * @description 支付方式枚举类
 * @date 2022/11/22
 */
@Getter
public enum PaymentTypeEnum implements BaseEnum {
    ALIPAY_TYPE(1, "支付宝"),
    WECHAT_TYPE(2, "微信"),
    XIAOMI_TYPE(3, "小米"),
    UNIONPAY_TYPE(4,"云闪付"),
    OTHER(9,"三方");

    public Integer code;
    public String desc;

    PaymentTypeEnum(int code ,String desc){
        this.code = code;
        this.desc = desc;
    }

}
