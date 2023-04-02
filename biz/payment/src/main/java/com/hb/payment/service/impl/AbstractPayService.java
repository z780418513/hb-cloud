package com.hb.payment.service.impl;

import com.hb.payment.constant.RedisConstants;
import com.hb.payment.enums.PaymentTypeEnum;
import com.hb.payment.mapper.PaymentOrderMapper;
import com.hb.payment.model.PaymentOrder;
import com.hb.payment.service.BasePay;
import com.hb.payment.service.PaymentOrderService;
import com.hb.payment.service.impl.AliPayService;
import com.hb.payment.utils.RedisUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@Slf4j
@Component
public abstract class AbstractPayService implements BasePay {
    @Resource
    private PaymentOrderService paymentOrderService;
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private AliPayService aliPayService;

    /**
     * 是否是第一次扫码
     *
     * @param token
     * @return
     */
    public boolean isFirst(String token) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        return redisUtils.del(token);
    }

    @Override
    public BasePay getByPaymentType(PaymentTypeEnum paymentTypeEnum) {
        if (paymentTypeEnum == PaymentTypeEnum.ALIPAY_TYPE) {
            return aliPayService;
        }
        return null;
    }

    @Override
    public String generateToken() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 过期时间3分钟
        boolean success = redisUtils.set(uuid, true, 3 * 60L);
        return success ? uuid : null;
    }
}
