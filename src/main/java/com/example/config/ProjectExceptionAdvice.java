package com.example.config;

import com.example.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有异常信息
    @ExceptionHandler
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return new Result("服务器故障，请稍后在试！");
    }
}
