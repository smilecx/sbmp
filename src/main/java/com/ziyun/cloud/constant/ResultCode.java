package com.ziyun.cloud.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author:chenxiaoyi
 * @Date:2019/1/31 19:24
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode {

    FAIL(0,"失败"),
    SUCCESS(1,"成功");


    private int code;
    private String message;

    public static ResultCode valueOf(int code){
        for (ResultCode result: values()) {
            if(result.code == code){
                return result;
            }
        }
        return null;
    }

}
