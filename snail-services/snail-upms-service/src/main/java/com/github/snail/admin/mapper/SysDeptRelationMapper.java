

package com.github.snail.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.snail.admin.model.entity.SysDeptRelation;


public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
    /**
     * 删除部门关系表数据
     *
     * @param id 部门ID
     */
    void deleteAllDeptRealtion(Integer id);

    /**
     * 更改部分关系表数据
     *
     * @param deptRelation
     */
    void updateDeptRealtion(SysDeptRelation deptRelation);
}