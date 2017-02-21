package cn.hncu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 5:23.
 * Explain:控制器
 */
@Controller
@RequestMapping("index")
public class Index {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
