package cn.hncu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/26.
 * Time: 下午 7:29.
 * Explain:Spring MVC 配置
 */
@Configuration
@EnableWebMvc
@ComponentScan("cn.hncu") //配置自动扫描的包
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");//映射路径-运行时代码会将我们的页面自动编译到/WEB-INF/classes/views/下
        viewResolver.setSuffix(".jsp");//实际页面后缀
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的目录
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("/index");
//        //addViewController是访问的URL，setViewName是设置index.jsp
//    }

}
