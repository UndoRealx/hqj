package com.hqjcloud.article.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConf {

    @ExceptionHandler
    public String handle(Exception e){
        return "{\"status\":\"error\",\"mes\":\"" + e.getMessage() + "\"}";
    }
}
