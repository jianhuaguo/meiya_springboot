package com.mei.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class myinterceptor implements HandlerInterceptor {

    //不用拦截的路径集合
    public static final String NO_INTERCEPTOR="/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
       String path=request.getServletPath();

//复杂请求会先发出option预请求做嗅探，而option不会带上sessionid，服务器则会新分配一个id给他导致与服务器保存好的id不一致导致这个请求被拦截，出现了跨域问题。
//解决方案如下
//拦截器截取到请求先进行判断，如果是option请求的话，则放行
        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            System.err.println("OP:OK");
            return true;
        }

       if(path.matches(NO_INTERCEPTOR))
       {
           return true;// 只有返回true才会继续向下执行，返回false取消当前请求
       }
        else {

           HttpSession session=request.getSession();
           String status=(String)session.getAttribute("login");
         //  System.out.println(status);

//           return true;
           if(status=="yes")
           {
               return true;
           }

           else
           {
//                String url="http://localhost:6925/login";
//               response.sendRedirect(url);
//               System.out.println("成功拦截，并跳转到"+url);
               return false;
           }

       }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
