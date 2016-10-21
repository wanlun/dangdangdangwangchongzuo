package com.hzit.controller;

import com.hzit.Interceptor.Check;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2016/10/10.
 */
@Controller
public class BaseController extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Check()).addPathPatterns("/controller/**");
        super.addInterceptors(registry);
    }
}