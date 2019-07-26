package com.mei.demo.interceptor;


import com.mei.demo.interceptor.myinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
    public class MyWebAppConfigurer implements  WebMvcConfigurer {

    private final myinterceptor myinterceptor;

    @Autowired
    public MyWebAppConfigurer(myinterceptor myinterceptor){
        this.myinterceptor=myinterceptor;
    }
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 多个拦截器组成一个拦截器链
            // addPathPatterns 用于添加拦截规则
            // excludePathPatterns 用户排除拦截
        registry.addInterceptor(myinterceptor).addPathPatterns("/**").excludePathPatterns("/login");

        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(true) //设置为true
                    .maxAge(3600);
        }

    }
