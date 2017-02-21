package cn.hncu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 9:23.
 * Explain:配置类
 */
@Configuration
@EnableWebMvc
@ComponentScan("cn.hncu") //自动扫描包名下所有使用@Service、@Component、@Repository和@Controller的leukemia，并注册为Bean
public class MyMvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");//映射路径-运行时代码会将我们的页面自动编译到/WEB-INF/classes/views/下
        viewResolver.setSuffix(".jsp");//实际页面后缀
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}