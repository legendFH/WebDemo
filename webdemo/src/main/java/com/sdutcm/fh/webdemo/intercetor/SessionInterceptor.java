package com.sdutcm.fh.webdemo.intercetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/*
@Configuration可理解为用spring的时候xml里面的<beans>标签

@Bean可理解为用spring的时候xml里面的<bean>标签
*/

@Configuration
/*
 implement

@Component
*/

public class SessionInterceptor implements WebMvcConfigurer {
    @Override
/*
*
        *自定义拦截器，添加拦截路径和排除拦截路径
 *

    addPathPatterns():添加需要拦截的路径
 *

    excludePathPatterns():添加不需要拦截的路径
*/


    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList();
        list.add("/index");
        list.add("/login");
        list.add("/asserts/**");
        list.add("/more");
        list.add("/register");
        list.add("success");
        list.add("/toRegister");
        list.add("/add");
        list.add("/main");

        list.add("/del");
        registry.addInterceptor(new UserIntercetor()).addPathPatterns("/**").excludePathPatterns(list);
    }
}
