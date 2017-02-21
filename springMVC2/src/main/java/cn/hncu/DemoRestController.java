package cn.hncu;

import cn.hncu.model.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 10:10.
 * Explain: @RestController演示
 */
@RestController //声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("rest")
public class DemoRestController {
    private static Logger logger = LoggerFactory.getLogger(DemoAnnoController.class);

    @RequestMapping(value = "getjson",produces = "application/json;charset=UTF-8")//返回数据的媒体类型为json
    public DemoObj getjson(DemoObj obj){
        logger.info("进入getjson方法.");
        return new DemoObj(obj.getId()+1,obj.getName()+" json");//直接返回对象，对象会自动转换成json
    }

    @RequestMapping(value = "getxml",produces = "application/xml;charset=UTF-8")//返回数据的媒体类型是xml
    public DemoObj getxml(DemoObj obj){
        logger.info("进入getxml方法.");
        return new DemoObj(obj.getId()+1,obj.getName()+" xml");//直接返回对象，对象会自动转换为xml
    }

}
