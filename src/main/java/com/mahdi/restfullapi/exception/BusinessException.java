package com.mahdi.restfullapi.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String errorMessage, Throwable ex) {
        super(errorMessage, ex);
    }

}
