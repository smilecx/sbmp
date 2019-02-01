package com.ziyun.cloud.config;

import com.ziyun.cloud.constant.BaseException;
import com.ziyun.cloud.constant.BaseResult;
import com.ziyun.cloud.constant.ResultCode;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 14:09
 */
@ControllerAdvice
public class GlobelHanderException {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResult<?> defaultErrorHander(HttpServletRequest request, HttpServletResponse response
            , Exception e) {
        String method = request.getMethod();
        if(StringUtils.equals(method, RequestMethod.GET.name())){
            try {
                response.sendRedirect("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        BaseResult<?> dto = null;
        BaseException baseException = (BaseException) e;
        ResultCode resultCode = baseException.getResultCode();
        String msg = resultCode == null ? baseException.getMessage() : resultCode.getMessage();
        if (resultCode == null) {
            if (NumberUtils.isNumber(msg)) {
                dto = BaseResult.error(ResultCode.valueOf(msg), msg);
            } else {
                msg = StringUtils.defaultIfBlank(msg, ResultCode.FAIL.getMessage());
                dto = BaseResult.error(ResultCode.FAIL, msg);
            }
        } else {
            dto = BaseResult.error(resultCode);
        }
        return dto;
    }

}
