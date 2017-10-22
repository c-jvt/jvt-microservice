package com.jvt.microservice.api.core.exception;

import com.jvt.microservice.domain.out.ResultBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(value = Exception.class)
    public ResultBody processGlobalException(Exception exception) {
        String defaultMessage = exception.getMessage();
        ResultBody result = new ResultBody();
        result.setMessage(defaultMessage);
        result.setCode("101");
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultBody processValidationError(MethodArgumentNotValidException exception) {
        String defaultMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ResultBody result = new ResultBody();
        result.setMessage(defaultMessage);
        result.setCode("100");
        return result;
    }
}

