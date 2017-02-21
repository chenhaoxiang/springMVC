package cn.hncu;

import cn.hncu.model.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 9:02.
 * Explain:控制器
 */
@Controller //声明此类是一个控制器
@RequestMapping("/chx") //映射此类的访问路径是/chx
public class DemoAnnoController {
    private static Logger logger = LoggerFactory.getLogger(DemoAnnoController.class);

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    //此方法未标注路径，因此使用类级别的路径/chx；
    // produces可定制返回的response的媒体类型和字符集，或需返回值是json对象，则设置produces = "text/plain;charset=UTF-8"
    public @ResponseBody String index(HttpServletRequest request){
        //演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletResponse作为参数，此处的@ResponseBody用在返回值前面
        logger.info("进入index方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access";
    }

    //演示接受路径参数，并在方法参数前结合@PathVariable使用！
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        logger.info("进入demoPathVar方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access，str:"+str;
    }

    //演示常规的request参数获取，访问路径为/chx/requestParam?id=001
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        logger.info("进入passRequestParam方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access,id:"+id;
    }

    //演示解释参数到对象，访问路径为/chx/obj/?id=001&name=chx
    @RequestMapping(value = "obj",produces = "application/json;charset=UTF-8")
    @ResponseBody //也可以放在方法上
    public String passObj(DemoObj obj,HttpServletRequest request){
        logger.info("进入passObj方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access,obj id:"+obj.getId()+" obj name:"+obj.getName();
    }

    //演示映射不同的路径到相同的方法上。
    //访问路径为/chx/name1 或/cha/name2
    @RequestMapping(value = {"/name1","name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        logger.info("进入remove方法！访问路径是："+request.getRequestURI());
        return "url:"+request.getRequestURI()+" can access";
    }

}
