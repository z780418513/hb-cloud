package com.hb.payment.service;

import com.hb.payment.bo.AbstractOrderRequest;
import com.hb.payment.bo.BaseTradeQuery;
import com.hb.payment.enums.PaymentTypeEnum;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/11/22
 */
public interface BasePay {
    /**
     * 扫码下单二维码
     *
     * @param order 订单信息
     * @return 预下单二维码地址
     */
    String getQrCode(AbstractOrderRequest order);


    /**
     * 交易查询
     *
     * @param tradeQuery
     * @return
     */
    String tradeQuery(BaseTradeQuery tradeQuery);

    /**
     * 根据PaymentTypeEnum 获取对应的payService
     *
     * @param paymentTypeEnum 支付类型枚举
     * @return BasePay
     */
    BasePay getByPaymentType(PaymentTypeEnum paymentTypeEnum);

    /**
     * 生成token，下单时传递
     * 过期时间3分钟
     *
     * @return token
     */
    String generateToken();
}
