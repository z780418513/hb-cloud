package com.hb.payment.service;

import com.hb.payment.bo.BaseOrder;
import com.hb.payment.bo.BaseTradeQuery;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/11
 */
public interface AliPayService extends BasePay{


    /**
     * 扫码下单二维码
     *
     * @param order 订单信息
     * @return 预下单二维码地址
     */
    String getQrCode(BaseOrder order);


    String tradeQuery(BaseTradeQuery tradeQuery);

}
