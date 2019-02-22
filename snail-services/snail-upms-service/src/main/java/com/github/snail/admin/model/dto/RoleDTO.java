

package com.github.snail.admin.model.dto;

import com.github.snail.admin.model.entity.SysRole;
import lombok.Data;


@Data
public class RoleDTO extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;
}
