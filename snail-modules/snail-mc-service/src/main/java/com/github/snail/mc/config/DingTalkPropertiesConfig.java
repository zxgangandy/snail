

package com.github.snail.mc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "sms.dingtalk")
public class DingTalkPropertiesConfig {
    /**
     * webhook
     */
    private String webhook;

}
