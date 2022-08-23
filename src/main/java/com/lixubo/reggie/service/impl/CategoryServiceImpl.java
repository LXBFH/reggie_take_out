package com.lixubo.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixubo.reggie.entity.Category;
import com.lixubo.reggie.mapper.CategoryMapper;
import com.lixubo.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 19:13
 * @description
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
