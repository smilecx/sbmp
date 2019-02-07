package com.ziyun.cloud.utils;

import com.ziyun.cloud.constant.MobileConstant;
import com.ziyun.cloud.module.operator.entity.Mobile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/7 11:42
 */
public class NumRandomUtils {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random random = new Random();

    //用于生成电话号码的工具类还要随机生成卡号
    public static List<Mobile> createNum(String startNum, String endNum,String mobileType) {
        List<Mobile> nums = new ArrayList<>();
        Long start = Long.parseLong(startNum);
        Date date =null;
        Long end = Long.parseLong(endNum);
        int length=(int)(end-start);
        for (int i = 0; i <= length; i++) {
            date = new Date();
            String str="";
            for (int j = 0; j < 4; j++) {
                //生成四个随机字母
                str = str+ (char)(Math.random()*26+'A');
            }

            String time = sdf1.format(date);
            Mobile m = new Mobile();
            m.setCardNumber(str + time);
            m.setMobileNumber(String.valueOf(start));
            m.setMobileType(mobileType);
            m.setAvailable(MobileConstant.AVAILABLE);
            nums.add(m);
            start++;
        }
        return nums;
    }
}
