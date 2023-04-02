package com.hb.payment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.payment.mapper.PaymentOrderMapper;
import com.hb.payment.model.PaymentOrder;
import com.hb.payment.service.PaymentOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@Service
@Slf4j
public class PaymentOrderServiceImpl extends ServiceImpl<PaymentOrderMapper, PaymentOrder>
        implements PaymentOrderService {

    @Override
    public PaymentOrder findByChannelOrderId(String channelOrderId) {
        return baseMapper.selectOne(Wrappers.<PaymentOrder>lambdaQuery()
                .eq(StringUtils.isNotBlank(channelOrderId), PaymentOrder::getChannelOrderId, channelOrderId));
    }
}
