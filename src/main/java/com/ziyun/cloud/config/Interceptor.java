package com.ziyun.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:chenxiaoyi
 * @Date:2019/2/1 14:03
 */
@Configuration
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String url = request.getRequestURI();
        String referer = request.getHeader("Referer");
        HttpSession session = request.getSession();

//        if(session.getAttribute("userId") == null){
//            if(StringUtils.equals(request.getHeader("X-Requested-With"),"XMLHttpRequest")){
//                //判断是ajax请求并未登陆
//                session.setAttribute("referer",referer == null?"/index/index":referer);
//                response.setStatus(HttpServletResponse.SC_FORBIDDEN);//暂未授权
//            }else{
//                session.setAttribute("referer", referer == null?"/index/index":referer );
//                response.sendRedirect("/login/index");
//            }
//            return false;
//        }
        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

}
