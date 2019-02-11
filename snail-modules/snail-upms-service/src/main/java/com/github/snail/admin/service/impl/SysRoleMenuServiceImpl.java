

package com.github.snail.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.snail.admin.mapper.SysRoleMenuMapper;
import com.github.snail.admin.model.entity.SysRoleMenu;
import com.github.snail.admin.service.SysRoleMenuService;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    @Override
    @CacheEvict(value = "menu_details", key = "#role + '_menu'")
    public Boolean insertRoleMenus(String role, Integer roleId,String menuIds) {
        SysRoleMenu condition = new SysRoleMenu();
        condition.setRoleId(roleId);
        this.delete(new EntityWrapper<>(condition));

        if (StrUtil.isBlank(menuIds)){
            return Boolean.TRUE;
        }

        if (StrUtil.isBlank(menuIds)) {
            return Boolean.TRUE;
        }

        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        List<String> menuIdList = Arrays.asList(menuIds.split(","));

        for (String menuId : menuIdList) {
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(Integer.valueOf(menuId));
            roleMenuList.add(roleMenu);
        }
        return this.insertBatch(roleMenuList);
    }
}
