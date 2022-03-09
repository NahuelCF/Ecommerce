package com.ecommerce.errorHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(BAD_REQUEST)
public class EcommerceException extends RuntimeException{
    EcommerceException(String msg){
        super(msg);
    }
}

