package com.greenhome.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author smart_joker
 * @Date 2022/1/27 2:29 下午
 * @Description 后管平台启动类
 * @Version 1.0
 */

@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages ={"com.greenhome"})
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class);
    }
}
