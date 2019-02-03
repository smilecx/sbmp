package com.ziyun.cloud.module.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ziyun.cloud.module.operator.service.IOperatorService;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/3 11:23
 */
@Controller
public class OperatorController {

    @Autowired
    private IOperatorService iOperatorService;

    private final String MODEL="operator";


    //跳转到操作员列表页面
    @GetMapping(MODEL+"/toLoadAllOperator")
    public ModelAndView toLoadAllOperator(){
        ModelAndView view = new ModelAndView("operatorlist");
        return view;
    }


    //加载所有的操作员列表
    @RequestMapping(MODEL+"/loadAllOperator")
    @ResponseBody
    public ModelAndView loadAllOperator(OperatorVo operatorVo){
        ModelAndView view = new ModelAndView();
        Page<OperatorVo> page = this.iOperatorService.loadAllOperator(operatorVo);
        view.addObject("page",page);
        return view;
    }
}
