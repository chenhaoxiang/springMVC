package cn.hncu.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 6:04.
 * Explain:定制ControllerAdvice
 */
@ControllerAdvice //声明一个控制器建言，@ControllerAdvice组合了@Component注解，所以自动注册为Spring的Bean
public class ExceptinHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    //@ExceptionHandler在此处定义全局处理，通过@ExceptionHandler的value属性可过滤拦截的条件，在此处我们可以看出我们拦截所有的Exception
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error"); //error页面
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }

    @ModelAttribute //此处使用@ModelAttribute 注解将键值对添加到全局，所有注解@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder //通过@InitBinder 注解定制 WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); //此处演示忽略request 参数的id
    }


}
