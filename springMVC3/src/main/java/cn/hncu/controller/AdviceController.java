package cn.hncu.controller;

import cn.hncu.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 8:08.
 * Explain:演示控制器
 */
@Controller
public class AdviceController {

    @RequestMapping("advice")
    public String getSomething(@ModelAttribute("msg") String msg , DemoObj obj){
        System.out.println("id:"+obj.getId()+" , name:"+obj.getName());
        //访问 http://localhost:8080/springMVC3/advice?id=1&name=chx
        //id:null , name:chx -因为id被过滤掉了！
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute："+msg);
    }

    @RequestMapping("pathvar/{str}")
    public @ResponseBody String pathvarDemo(@PathVariable String str){
        return "str:"+str;
    }

}
