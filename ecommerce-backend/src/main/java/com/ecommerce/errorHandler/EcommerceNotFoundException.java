package com.ecommerce.errorHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class EcommerceNotFoundException extends EcommerceException {
    public EcommerceNotFoundException(String msg) {
        super(msg);
    }
}
