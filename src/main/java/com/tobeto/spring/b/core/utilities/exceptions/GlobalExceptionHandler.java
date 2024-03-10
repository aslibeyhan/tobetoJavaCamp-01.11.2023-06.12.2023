package com.tobeto.spring.b.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //exceptionun typenı vermek ---> .class demesinin sebebi
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //hata ne ise ona göre dönüş yapar bu yapı ile.
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception)
    {
        Map<String ,String> errors=new HashMap<>();
        for(FieldError error:exception.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handeRuntimeError(RuntimeException exception ){
        return exception.getMessage();
    }



    //Known Types
    //Unknown Types
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownErrors(){
        return "Bilinmedik hata";
    }
}
