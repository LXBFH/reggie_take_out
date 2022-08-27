package com.lixubo.reggie.dto;

import com.lixubo.reggie.entity.Setmeal;
import com.lixubo.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

/**
 * @Author LIXUBO
 * @Date 2022-08-27 15:54
 * @description
 * @Version 1.0
 */
@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}

