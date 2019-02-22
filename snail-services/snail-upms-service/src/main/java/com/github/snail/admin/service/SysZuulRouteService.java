

package com.github.snail.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.snail.common.entity.SysZuulRoute;


public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
