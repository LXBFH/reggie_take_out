package com.lixubo.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lixubo.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LIXUBO
 * @Date 2022-08-22 16:59
 * @description
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
