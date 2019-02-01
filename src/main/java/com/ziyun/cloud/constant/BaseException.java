package com.ziyun.cloud.constant;

/**
 * @Author:chenxiaoyi
 * @Date:2019/1/31 19:23
 */
public class BaseException extends RuntimeException {

    private ResultCode resultCode;

    public BaseException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String message, ResultCode resultCode) {
        super(String.valueOf(resultCode.getCode()),new Throwable(resultCode.getMessage()));
        this.resultCode = resultCode;
    }

    public BaseException(int code,String msg){
        super(String.valueOf(code),new Throwable(msg));
    }

    public BaseException(String message, Throwable cause, ResultCode resultCode) {
        super(message, cause);
        this.resultCode = resultCode;
    }

    public BaseException(Throwable cause, ResultCode resultCode) {
        super(cause);
        this.resultCode = resultCode;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultCode resultCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultCode = resultCode;
    }
}
