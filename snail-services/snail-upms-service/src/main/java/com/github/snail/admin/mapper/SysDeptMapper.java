

package com.github.snail.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.snail.admin.model.entity.SysDept;

import java.util.List;

public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 关联dept——relation
     *
     * @param delFlag 删除标记
     * @return 数据列表
     */
    List<SysDept> selectDeptDtoList(String delFlag);
}