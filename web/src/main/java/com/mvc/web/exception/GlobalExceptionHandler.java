package com.mvc.web.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.HandlesTypes;

import com.mvc.web.entity.Entiy;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @desciption 全局异常处理类
 * @author ChenXiHua
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Entiy runtimeExceptionHandler(RuntimeException ex){
        return new Entiy();
    }


}