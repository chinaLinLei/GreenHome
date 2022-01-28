package com.greenhome.manage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
/**
 * @Author smart_joker
 * @Date 2022/1/28 4:23 下午
 * @Description 注解用于开启事务
 * @Version 1.0
 */
@SpringBootConfiguration
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{
    @Autowired
    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
