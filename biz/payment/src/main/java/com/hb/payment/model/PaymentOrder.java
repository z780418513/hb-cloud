package com.hb.payment.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */

@Data
@Accessors(chain = true)
@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "payment_order")
public class PaymentOrder {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 1:支付宝 2:微信
     */
    @TableField(value = "payment_type")
    private Integer paymentType;

    /**
     * 支付金额
     */
    @TableField(value = "payment_price")
    private BigDecimal paymentPrice;

    /**
     * 用户id
     */
    @TableField(value = "account_id")
    private String accountId;

    /**
     * 渠道订单id
     */
    @TableField(value = "channel_order_id")
    private String channelOrderId;
}
