

package com.github.snail.gateway.component.handler;


import com.github.snail.common.constant.SecurityConstants;
import com.github.snail.gateway.util.RibbonVersionHolder;
import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.PredicateKey;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class MetadataCanaryRuleHandler extends ZoneAvoidanceRule {

    @Override
    public AbstractServerPredicate getPredicate() {
        return new AbstractServerPredicate() {
            @Override
            public boolean apply(PredicateKey predicateKey) {
                String targetVersion = RibbonVersionHolder.getContext();
                RibbonVersionHolder.clearContext();
                if (StrUtil.isBlank(targetVersion)) {
                    log.debug("客户端未配置目标版本直接路由");
                    return true;
                }

                DiscoveryEnabledServer server = (DiscoveryEnabledServer) predicateKey.getServer();
                final Map<String, String> metadata = server.getInstanceInfo().getMetadata();
                if (StrUtil.isBlank(metadata.get(SecurityConstants.VERSION))) {
                    log.debug("当前微服务{} 未配置版本直接路由");
                    return true;
                }

                if (metadata.get(SecurityConstants.VERSION).equals(targetVersion)) {
                    return true;
                } else {
                    log.debug("当前微服务{} 版本为{}，目标版本{} 匹配失败", server.getInstanceInfo().getAppName()
                            , metadata.get(SecurityConstants.VERSION), targetVersion);
                    return false;
                }
            }
        };
    }
}
