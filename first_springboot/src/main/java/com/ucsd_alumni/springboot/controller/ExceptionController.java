package com.ucsd_alumni.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ucsd_alumni.springboot.exception.ServerException;
import com.ucsd_alumni.springboot.model.ErrorResponse;

@ControllerAdvice
public class ExceptionController {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionController.class);
    
    /**
     * Handles <code>Exception</code> exception.
     * 
     * @param ex Exception to handle
     * @return <code>ResponseEntity</code>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        LOG.error(String.format("Exception caught, message is '%s'", 
                ex.getLocalizedMessage()));
        ErrorResponse errorRes = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), "System Error");
        return new ResponseEntity<ErrorResponse>(errorRes, 
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Handles <code>ServerException</code> exception.
     * 
     * @param ex ServerException to handle
     * @return <code>ResponseEntity</code>
     */
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ErrorResponse> handleServerException(ServerException ex) {
        LOG.error(String.format("ServerException caught, status code will be '%s'" + 
                ", response message is '%s'",
                ex.getHttpStatusCode(),ex.getLocalizedMessage()));
        return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), 
                ex.getHttpStatusCode());
    }
    
}
