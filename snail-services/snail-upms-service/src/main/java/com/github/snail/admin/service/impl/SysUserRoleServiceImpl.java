
package com.github.snail.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.snail.admin.mapper.SysUserRoleMapper;
import com.github.snail.admin.model.entity.SysUserRole;
import com.github.snail.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {


    @Override
    public Boolean deleteByUserId(Integer userId) {
        return baseMapper.deleteByUserId(userId);
    }
}
