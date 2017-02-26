package cn.hncu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/26.
 * Time: 下午 7:35.
 * Explain:简单的控制器
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

}
