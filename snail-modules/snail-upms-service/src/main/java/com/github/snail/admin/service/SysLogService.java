

package com.github.snail.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.snail.common.entity.SysLog;


public interface SysLogService extends IService<SysLog> {

    /**
     * 通过ID删除日志（逻辑删除）
     *
     * @param id 日志ID
     * @return true/false
     */
    Boolean updateByLogId(Long id);
}
