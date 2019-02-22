

package com.github.snail.gateway.component.filter;

import com.github.snail.common.constant.SecurityConstants;
import com.github.snail.gateway.util.RibbonVersionHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

@Component
public class AccessFilter extends ZuulFilter {
    @Value("${zuul.ribbon.metadata.enabled:false}")
    private boolean canary;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String version = requestContext.getRequest().getHeader(SecurityConstants.VERSION);
        if (canary && StrUtil.isNotBlank(version)) {
            RibbonVersionHolder.setContext(version);
        }

        requestContext.set("startTime", System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
            requestContext.addZuulRequestHeader(SecurityConstants.ROLE_HEADER, CollectionUtil.join(authentication.getAuthorities(), ","));
        }
        return null;
    }
}
