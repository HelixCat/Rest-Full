package com.mahdi.restfullapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalProductExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalProductExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
        LOGGER.error("Exception occurred:", ex);
        return ResponseEntity.status(400).body("Not Found Product!! \n" + "Please check id or name!!! \n" + ex.getCause());
    }

}
