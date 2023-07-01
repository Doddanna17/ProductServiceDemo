package com.doddanna.ProductService.configs;

import com.doddanna.ProductService.exceptions.BadRequestException;
import com.doddanna.ProductService.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseModel badRequest(BadRequestException badRequestException){
        return ResponseModel
                .builder()
                .message(badRequestException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
