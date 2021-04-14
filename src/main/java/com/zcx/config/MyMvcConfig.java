package com.zcx.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");


    }
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginHandlerInterceptor())
                    .addPathPatterns("/index","/findAll","/charts","/tables","/find","/ipinfo","/eventinfo","/Sensors/a","/Sensors/e");
//                    .excludePathPatterns("/login","/","/test","/toupdate","/login.html","/asserts/**","/webjars/bootstrap/**","/webjars/bootstrap/3.3.5/css");
        }
}