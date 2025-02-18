package com.fpmislata.exam.common.error;

import com.fpmislata.exam.common.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceAccessException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(ResourceNotFoundException e) {
        e.printStackTrace();
        return new ErrorMessage(e);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    public ErrorMessage handleValidationException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return new ErrorMessage(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleGeneralException(Exception e){
        e.printStackTrace();
        return new ErrorMessage(e);
    }
}
