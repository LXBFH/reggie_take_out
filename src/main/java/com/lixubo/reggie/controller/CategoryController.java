package com.lixubo.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lixubo.reggie.common.R;
import com.lixubo.reggie.entity.Category;
import com.lixubo.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 19:09
 * @description 分类管理
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param category
     * @return
     */
    @PostMapping
    public R<String> sava(@RequestBody Category category) {
        log.info("category:{}", category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        log.info("Page = {} , pageSize = {} ", page, pageSize);
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort);

        //执行查询
        categoryService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        log.info("删除分类,id为:{}", id);
//        categoryService.removeById(id);
        categoryService.remove(id);
        return R.success("删除分类成功");
    }
}
