package com.lixubo.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixubo.reggie.entity.Category;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 19:12
 * @description
 * @Version 1.0
 */
public interface CategoryService extends IService<Category> {
    /**
     * 自定义删除方法
     * @param id
     */
    public void remove(Long id);
}
