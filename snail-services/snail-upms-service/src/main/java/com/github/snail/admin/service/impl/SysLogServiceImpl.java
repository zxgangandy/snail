

package com.github.snail.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.snail.admin.mapper.SysLogMapper;
import com.github.snail.admin.service.SysLogService;
import com.github.snail.common.constant.CommonConstant;
import com.github.snail.common.entity.SysLog;
import com.github.snail.common.util.Assert;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public Boolean updateByLogId(Long id) {
        Assert.isNull(id, "日志ID为空");

        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        sysLog.setDelFlag(CommonConstant.STATUS_DEL);
        sysLog.setUpdateTime(new Date());
        return updateById(sysLog);
    }
}
