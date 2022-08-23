package com.lixubo.test;

import org.junit.jupiter.api.Test;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 23:55
 * @description
 * @Version 1.0
 */
public class UploadFileTest {
    @Test
    public void Test1(){
        String fileName = "sgfiury.jpg";
        String substring = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(substring);
    }
}
