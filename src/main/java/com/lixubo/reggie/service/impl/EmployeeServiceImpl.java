package com.lixubo.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lixubo.reggie.entity.Employee;
import com.lixubo.reggie.mapper.EmployeeMapper;
import com.lixubo.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author LIXUBO
 * @Date 2022-08-22 17:02
 * @description
 * @Version 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
}
