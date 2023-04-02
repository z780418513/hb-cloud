package com.hb.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hb.payment.model.PaymentOrder;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
public interface PaymentOrderService extends IService<PaymentOrder> {

    PaymentOrder findByChannelOrderId (String channelOrderId);
}
