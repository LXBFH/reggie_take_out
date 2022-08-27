package com.lixubo.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lixubo.reggie.dto.SetmealDto;
import com.lixubo.reggie.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐
     *
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);
}
