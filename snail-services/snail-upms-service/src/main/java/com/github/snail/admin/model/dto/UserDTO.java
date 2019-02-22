

package com.github.snail.admin.model.dto;

import com.github.snail.admin.model.entity.SysUser;
import lombok.Data;

import java.util.List;


@Data
public class UserDTO extends SysUser {
    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;
}
