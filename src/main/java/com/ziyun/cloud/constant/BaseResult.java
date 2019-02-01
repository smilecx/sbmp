package com.ziyun.cloud.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 14:10
 */
@Getter
@Setter
public class BaseResult<T> {

    private int code;

    private T date;

    private String message;

    public BaseResult() {
    }

    public BaseResult(ResultCode resultCode) {
        this.code=resultCode.getCode();
        this.message=resultCode.getMessage();
    }

    //成功返回
    public static <T> BaseResult<T> success(){
        return new BaseResult<T>(ResultCode.SUCCESS);
    }
    //成功返回
    public static <T> BaseResult<T> success(String  message){
        BaseResult<T> result = new BaseResult<>(ResultCode.SUCCESS);
        result.setMessage(message);
        return result;
    }
    public static <T> BaseResult<T> success(T t){
        BaseResult<T> result = new BaseResult<>(ResultCode.SUCCESS);
        result.setDate(t);
        return result;
    }
    //失敗
    public static <T> BaseResult<T> error(String message){
        BaseResult<T> result = new BaseResult<>(ResultCode.FAIL);
        result.setMessage(message);
        return result;

    }
    //失敗的
    public static <T> BaseResult<T> error(ResultCode resultCode){
        BaseResult<T> result = new BaseResult<>(resultCode);
        return result;
    }
    public static <T> BaseResult<T> error(ResultCode resultCode,String message){
        BaseResult<T> result = new BaseResult<>(resultCode);
        result.setMessage(message);
        return result;
    }

}
