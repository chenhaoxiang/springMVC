package cn.hncu.filter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/21.
 * Time: 下午 5:00.
 * Explain:拦截器
 */
//继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter{
    //如果需要拦截特定的网址，可利用正则映射到需要拦截的路径 ，然后在preHandle方法中判断request.getRequestURL().toString()，进行匹配，用matches方法。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //重写preHandle方法，在请求发生前执行
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //重写postHandle方法，在请求完成后执行
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+ new Long(endTime - startTime) +" ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
