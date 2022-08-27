package com.lixubo.reggie.dto;

import com.lixubo.reggie.entity.Dish;
import com.lixubo.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    /**
     * 菜品分类名
     */
    private String categoryName;

    private Integer copies;
}
