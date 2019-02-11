

package com.github.snail.admin.model.dto;

import com.github.snail.admin.model.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private String[] roles;
}
