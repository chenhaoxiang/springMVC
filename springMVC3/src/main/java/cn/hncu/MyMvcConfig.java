package cn.hncu;

import cn.hncu.filter.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 4:09.
 * Explain:配置类
 */
@Configuration
@EnableWebMvc //开启SpringMVC支持，如无此注解，重写WebMvcConfigurerAdapter类的方法无效
@ComponentScan("cn.hncu")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    //集成WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/assets/");
        //addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的目录，
    }

    @Bean //配置拦截器的Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//重写addInterceptors方法，注册拦截器
        registry.addInterceptor(demoInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/inn").setViewName("/in");
        //addViewController是访问的URL，setViewName是设置in.jsp
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);//不忽略 "."后面的参数
    }
}
