package com.hb.payment.bo;

import com.hb.payment.enums.PaymentTypeEnum;
import lombok.Data;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/15
 */
@Data
public abstract class AbstractOrderRequest {
    /**
     * 用户id
     */
    private String accountId;

    /**
     * 渠道方订单id
     */
    private String channelOrderId;

    /**
     * uuid 防止重复请求
     */
    private String uuid;

    /**
     * 支付类型
     */
    private PaymentTypeEnum paymentTypeEnum;

}
