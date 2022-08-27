package com.lixubo.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixubo.reggie.dto.DishDto;
import com.lixubo.reggie.entity.Dish;
import com.lixubo.reggie.entity.DishFlavor;
import com.lixubo.reggie.mapper.DishMapper;
import com.lixubo.reggie.service.DishFlavorService;
import com.lixubo.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;
    /**
     * 新增菜品，同时保存对应的口味数据
     * @param dishDto
     * @Transactional  事务控制
     *
     */
    @Transactional
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);

        Long dishId = dishDto.getId();//菜品id

        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {

        //查询菜品基本信息 dish表中查
        Dish dish = this.getById(id);

        //对象拷贝
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //查询菜品口味信息 dish——flavor表中查
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);

        dishDto.setFlavors(flavors);

        return dishDto;
    }

    /**
     * @param dishDto
     */
    @Override
    public void updateWithFlavor(DishDto dishDto) {

    }
}
