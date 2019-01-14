package com.jt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("time.preHandle()");
        long startTime = System.nanoTime();
        request.setAttribute("nanoTime",startTime);
        System.out.println(startTime);
        //true 表示放行 false 表示拦截


      return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("time.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("time.afterCompletion()");

        long endTime = System.nanoTime();
        long startTime=(Long)request.getAttribute("startTime");
        System.out.println("time:"+(endTime-startTime));

    }
}
