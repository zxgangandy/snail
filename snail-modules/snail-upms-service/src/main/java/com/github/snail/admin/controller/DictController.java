

package com.github.snail.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.snail.admin.model.entity.SysDict;
import com.github.snail.admin.service.SysDictService;
import com.github.snail.common.constant.CommonConstant;
import com.github.snail.common.util.Query;
import com.github.snail.common.util.R;
import com.github.snail.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    public SysDict dict(@PathVariable Integer id) {
        return sysDictService.selectById(id);
    }

    /**
     * 分页查询字典信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/dictPage")
    public Page dictPage(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return sysDictService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 通过字典类型查找字典
     *
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    @Cacheable(value = "dict_details", key = "#type")
    public List<SysDict> findDictByType(@PathVariable String type) {
        SysDict condition = new SysDict();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        condition.setType(type);
        return sysDictService.selectList(new EntityWrapper<>(condition));
    }

    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @PostMapping
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    public R<Boolean> dict(@RequestBody SysDict sysDict) {
        return new R<>(sysDictService.insert(sysDict));
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}/{type}")
    @CacheEvict(value = "dict_details", key = "#type")
    public R<Boolean> deleteDict(@PathVariable Integer id, @PathVariable String type) {
        return new R<>(sysDictService.deleteById(id));
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    @CacheEvict(value = "dict_details", key = "#sysDict.type")
    public R<Boolean> editDict(@RequestBody SysDict sysDict) {
        return new R<>(sysDictService.updateById(sysDict));
    }
}
