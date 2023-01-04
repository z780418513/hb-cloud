package com.hb.payment.bo;

import com.hb.payment.bo.BaseOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliPayOrder implements BaseOrder {
    /**
     * 通知回调地址<p>
     * 支付宝服务器主动通知商户服务器里指定的页面http/https路径。
     */
    private String notifyUrl;

    /**
     * 商户订单号<p>
     * 由商家自定义，64个字符以内，仅支持字母、数字、下划线且需保证在商户端不重复。
     */
    private String outTradeNo;

    /**
     * 订单总金额<p>
     * 单位为元，精确到小数点后两位，取值范围为 [0.01,100000000]，金额不能为 0。
     * 如果同时传入了【可打折金额】，【不可打折金额】，【订单总金额】三者，
     * 则必须满足如下条件：【订单总金额】=【可打折金额】+【不可打折金额】
     */
    private BigDecimal totalAmount;


    /**
     * 订单标题<p>
     * 注意：不可使用特殊字符，如 /，=，& 等。
     */
    private String subject;

}
