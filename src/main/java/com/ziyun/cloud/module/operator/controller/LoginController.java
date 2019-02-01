package com.ziyun.cloud.module.operator.controller;

import com.ziyun.cloud.constant.BaseException;
import com.ziyun.cloud.constant.BaseResult;
import com.ziyun.cloud.constant.ResultCode;
import com.ziyun.cloud.module.operator.entity.Operator;
import com.ziyun.cloud.module.operator.service.IOperatorService;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 14:40
 */
@Controller
public class LoginController {

    @Autowired
    private IOperatorService iOperatorService;

    private final String MODEL = "login";

    //跳转到登录页面
    @RequestMapping(MODEL + "/toLogin")
    public ModelAndView toLogin() {
        ModelAndView view = new ModelAndView("/login");
        return view;
    }

    @RequestMapping(MODEL + "/doLogin")
    @ResponseBody
    public BaseResult<?> doLogin(@RequestBody OperatorVo operatorVo, HttpServletRequest request) {
        BaseResult<?> baseResult = null;
        if (null != operatorVo) {
            Operator operator = this.iOperatorService.getOperatorByIdAndPwd(operatorVo);
            if (null != operator) {
                //登陆成功 存放到session中
               request.getSession().setAttribute("operator",operator);
                //跳转到index.html
                baseResult = BaseResult.success("/toIndex");
            } else {
                throw new BaseException(ResultCode.FAIL);
            }
        }
        return baseResult;
    }

    //跳转到首页
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        ModelAndView view = new ModelAndView("/index");
        return view;
    }

    //跳转到info界面去
    @RequestMapping(MODEL + "/toInfo")
    public ModelAndView toInfo() {
        ModelAndView view = new ModelAndView("/info");
        return view;
    }

}
