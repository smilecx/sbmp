package com.ziyun.cloud.module.operator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 14:40
 */
@Controller
public class LoginController {

    private final String MODEL="login";
    //跳转到登录页面
    @RequestMapping(MODEL+"/toLogin")
    public ModelAndView toLogin(){
        ModelAndView view = new ModelAndView("/login");
        return view;
    }
}
