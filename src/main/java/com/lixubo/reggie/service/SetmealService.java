package com.lixubo.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixubo.reggie.dto.SetmealDto;
import com.lixubo.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐
     *
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐 和 套餐，菜品关联
     *
     * @param ids
     */
    public void deleteWithDish(List<Long> ids);
}
