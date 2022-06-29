package com.greenhome.manage.config;

import com.greenhome.manage.aop.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

/**
 * @Author smart_joker
 * @Date 2022/6/23 9:43 上午
 * @Description 处理 spring 框架提供的转换器
 * 解决StringHttpMessageConverter.getContentLength，ClassCastException
 * @Version 1.0
 */

@Configuration
public class WebConfiguration  implements WebMvcConfigurer {

    /**
     * 把Interceptor 这个实现交给spring进行管理
     * 避免：拦截器是在spring创建controller之前运行的，这时候这些controller，service，实体类
     * 等等这些东西spring并没有去创建，注入失败
     * @return
     */
    @Bean
    CommonInterceptor getCommonInterceptor(){
        return  new CommonInterceptor();
    }

    /**
     * 重写addInterceptors()实现拦截器
     * 配置：要拦截的路径以及不拦截的路径
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        //添加拦截器,可以添加多个
        //注册Interceptor拦截器(Interceptor这个类是我们自己写的拦截器类)
        InterceptorRegistration registration = registry.addInterceptor(getCommonInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns(
                //登录
                "/manage/login",
                //退出登录
                "/manage/loginOut",
                //获取验证码
                "/manage/getCode",
                //发送短信
                "/manage/sendshortMessage",
                //重置账号
                "/manage/unsealaccount",
                //文件上传
                "/manage/uploadImg",
                //html静态资源
                "/**/*.html",
                //js静态资源
                "/**/*.js",
                //css静态资源
                "/**/*.css"
        );
    }
    /**
     * 重写addCorsMappings()解决跨域问题
     * 配置：允许http请求进行跨域访问
     *
     * @param registry
     * @Author 有梦想的肥宅
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //指哪些接口URL需要增加跨域设置
        registry.addMapping("/**")
                .allowedOrigins("*")//指的是前端哪些域名被允许跨域
                //需要带cookie等凭证时，设置为true，就会把cookie的相关信息带上
                .allowCredentials(true)
                //指的是允许哪些方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //cookie的失效时间，单位为秒（s），若设置为-1，则关闭浏览器就失效
                .maxAge(3600);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 第一种方式是将 json 处理的转换器放到第一位，使得先让 json 转换器处理返回值，这样 String转换器就处理不了了。
       converters.add(0, new MappingJackson2HttpMessageConverter());
        // 第二种就是把String类型的转换器去掉，不使用String类型的转换器
        //converters.removeIf(httpMessageConverter -> httpMessageConverter.getClass() == StringHttpMessageConverter.class);
    }
}
