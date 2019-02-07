package com.ziyun.cloud.module.operator.controller;

import com.ziyun.cloud.constant.BaseResult;
import com.ziyun.cloud.constant.ResultCode;
import com.ziyun.cloud.module.operator.entity.Mobile;
import com.ziyun.cloud.module.operator.service.IMobileService;
import com.ziyun.cloud.module.operator.vo.MobileVo;
import com.ziyun.cloud.utils.NumRandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/7 11:16
 */
@Controller
public class MobileController {

    private final String MODEL="mobile";

    @Autowired
    private IMobileService mobileService;

    //资源管理的方法
    @GetMapping(MODEL+"/toAddResource")
    public ModelAndView toAddResource(){
        ModelAndView view = new ModelAndView("addResource");
        return view;
    }

    @PostMapping(MODEL+"/addMobileResource")
    @ResponseBody
    public BaseResult addMobileResource(@RequestBody MobileVo mobileVo){
        List<Mobile> mobiles = NumRandomUtils.createNum(mobileVo.getStartNum(), mobileVo.getEndNum(),mobileVo.getMobileType());
        boolean b = mobileService.saveBatch(mobiles);
        if(b){
            return BaseResult.success(ResultCode.SUCCESS);
        }else{
            return BaseResult.error(ResultCode.FAIL);
        }
    }

}
