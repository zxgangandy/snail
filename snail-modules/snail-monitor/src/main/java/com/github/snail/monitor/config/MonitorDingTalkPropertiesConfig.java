

package com.github.snail.monitor.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;


@Data
@ConditionalOnExpression("!'${webhook}'.isEmpty()")
public class MonitorDingTalkPropertiesConfig {
    /**
     * 是否开启钉钉通知
     */
    private Boolean enabled;
}
