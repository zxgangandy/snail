

package com.github.snail.admin.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.snail.admin.model.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    Boolean deleteByUserId(@Param("userId") Integer userId);
}