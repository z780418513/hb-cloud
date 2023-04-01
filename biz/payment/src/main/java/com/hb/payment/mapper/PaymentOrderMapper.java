package com.hb.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.payment.model.PaymentOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@Mapper
public interface PaymentOrderMapper extends BaseMapper<PaymentOrder> {
}
