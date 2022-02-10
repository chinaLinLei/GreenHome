package com.greenhome.manage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author smart_joker
 * @Date 2022/2/9 4:18 下午
 * @Description Swagger2配置类
 * @Version 1.0
 */

@SpringBootConfiguration
@EnableSwagger2
public class Swagger2Configuration {

    @Value("${swagger2.packageScan}")
    private String packageScan;
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.description}")
    private String description;
    @Value("${swagger2.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    @Value("${swagger2.license}")
    private String license;
    @Value("${swagger2.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(packageScan))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .license(license)
                .version(version)
                .build();
    }
}
