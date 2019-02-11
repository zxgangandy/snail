

package com.github.snail.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.github.snail.admin.model.entity.SysUserRole;


public interface SysUserRoleService extends IService<SysUserRole> {


    Boolean deleteByUserId(Integer userId);
}
