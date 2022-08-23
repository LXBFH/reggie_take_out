package com.lixubo.reggie.common;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 21:55
 * @description
 * @Version 1.0
 */

/**
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
