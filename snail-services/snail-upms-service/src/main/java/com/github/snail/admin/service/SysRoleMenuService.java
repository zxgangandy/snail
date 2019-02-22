
package com.github.snail.admin.service;


import com.baomidou.mybatisplus.service.IService;
import com.github.snail.admin.model.entity.SysRoleMenu;


public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单
     *
     *
     * @param role
     * @param roleId  角色
     * @param menuIds 菜单列表
     * @return
     */
    Boolean insertRoleMenus(String role, Integer roleId, String menuIds);
}
