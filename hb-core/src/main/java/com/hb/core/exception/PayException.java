package com.hb.core.exception;

import com.hb.core.enums.PayExceptionEnum;

/**
 * @author zhaochengshui
 * @description 支付异常类
 * @date 2023/3/31
 */
public class PayException extends RuntimeException {

    public PayException(String message) {
        super(message);
    }

    public PayException(PayExceptionEnum payExceptionEnum) {
        super(payExceptionEnum.getErrorCode());
    }
}
