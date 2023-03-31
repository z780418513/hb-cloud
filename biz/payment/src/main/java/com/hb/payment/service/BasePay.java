package com.hb.payment.service;

import com.hb.payment.bo.BaseOrder;
import com.hb.payment.bo.BaseTradeQuery;

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
    String getQrCode(BaseOrder order);


    /**
     * 交易查询
     *
     * @param tradeQuery
     * @return
     */
    String tradeQuery(BaseTradeQuery tradeQuery);
}
