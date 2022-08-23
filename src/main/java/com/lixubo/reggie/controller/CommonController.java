package com.lixubo.reggie.controller;

import com.lixubo.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author LIXUBO
 * @Date 2022-08-23 23:01
 * @description 文件上传与下载
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     * 参数名  file  与浏览器对应
     * Content-Disposition: form-data; name="file"; filename="300376.jpeg"
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //file是一个临时文件，得转
        log.info(file.toString());

        //原始文件名,名称重复会出现覆盖问题
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //防止名称重复，用UUID重新生成文件名, 加原始文件的后缀，  .jpg
        String fileName = UUID.randomUUID().toString() + suffix;

        //创建目录
        File dir = new File(basePath);
        //判断当前目录是否存在，不存在就创建
        if(!dir.exists()){
            //目录不存在，创建目录
            dir.mkdir();
        }
        try {
            //将临时文件存到指定位置
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }
}
