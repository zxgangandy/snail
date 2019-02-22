

package com.github.snail.gateway.feign.fallback;

import com.github.snail.common.vo.MenuVO;
import com.github.snail.gateway.feign.MenuService;
import com.xiaoleilu.hutool.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * why add @Service when i up version ?
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/762
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
