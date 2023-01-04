package com.hb.payment.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/1/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliPayTradeQuery implements BaseTradeQuery {
    /**
     * 商家订单号<p>
     * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。
     * trade_no,out_trade_no如果同时存在优先取trade_no
     */
    private String outTradeNo;
    /**
     * 支付宝交易号<p>
     * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。
     * trade_no,out_trade_no如果同时存在优先取trade_no
     */
    private String tradeNo;

    /**
     * 查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式。支持枚举如下：
     * fund_bill_list：交易支付使用的资金渠道；
     * voucher_detail_list：交易支付时使用的所有优惠券信息；
     * discount_goods_detail：交易支付所使用的单品券优惠的商品优惠信息；
     * mdiscount_amount：商家优惠金额；
     */
    private List<String> queryOptions;
}
