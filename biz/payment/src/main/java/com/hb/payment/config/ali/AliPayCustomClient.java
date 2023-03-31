package com.hb.payment.config.ali;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaochengshui
 * @description
 * @date 2022/12/11
 */
@Configuration
@ConfigurationProperties(prefix = "hb.alipay")
@Data
public class AliPayCustomClient {
    /**
     * 请求网关地址
     */
    private String serverUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * appId
     */
    private String appId;

    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 公钥
     */
    private String aliPayPublishKey;

    /**
     * 默认format
     */
    private String defaultFormat = "json";

    /**
     * 默认字符集
     */
    private String defaultCharset = "GBK";

    /**
     * 加密类型 RSA2
     */
    private String defaultSingeType = "RSA2";

    @Bean("alipayClient")
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(serverUrl, appId, privateKey, defaultFormat, defaultCharset,
                aliPayPublishKey, defaultSingeType);
    }
}
