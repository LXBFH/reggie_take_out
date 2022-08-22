package com.lixubo.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Slf4j 日志
 * @SpringBootApplication 启动类
 * @ServletComponentScan  扫描过滤器等注解
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
public class ReggieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class, args);
        log.info("李旭博的项目启动成功");
    }

}
