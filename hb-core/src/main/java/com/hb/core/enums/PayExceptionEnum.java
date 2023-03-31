package com.hb.core.enums;

import lombok.Getter;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/3/31
 */
@Getter
public enum PayExceptionEnum {
    PAY_FAIL("PAY_FAIL", "支付失败");


    private String errorCode;
    private String errorMsg;

    PayExceptionEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
