package com.hb.payment.controller;

import com.hb.core.Result;
import com.hb.core.ValidGroup;
import com.hb.payment.bo.AliPayOrder;

import com.hb.payment.bo.BaseTradeQuery;
import com.hb.payment.service.AliPayService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/1/3
 */
@RestController
@RequestMapping("/ali/pay")
public class AliPayController {
    @Resource
    private AliPayService aliPayService;

    /**
     * 获取扫码下单二维码地址
     *
     * @param order 订单信息
     * @return 二维码地址(有效时间2小时)
     */
    @PostMapping("/getQrCode")
    public Result getQrCode(@Validated(ValidGroup.Add.class) @RequestBody AliPayOrder order) {
        return Result.success(aliPayService.getQrCode(order));
    }

    @GetMapping("/tradeQuery")
    public Result tradeQuery(BaseTradeQuery tradeQuery) {
        return Result.success(aliPayService.tradeQuery(tradeQuery));
    }
}
