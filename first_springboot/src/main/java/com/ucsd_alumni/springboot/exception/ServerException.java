package com.ucsd_alumni.springboot.exception;

import org.springframework.http.HttpStatus;

import com.ucsd_alumni.springboot.model.ErrorResponse;

public class ServerException extends Exception {
    private static final long serialVersionUID = -34892115955738067L;

    public ServerException() {
        super();
    }
    
    public ServerException(String message) {
        super(message);
    }
    
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServerException(Throwable cause) {
        super(cause);
    }
    
    public HttpStatus getHttpStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    
    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                this.getMessage());
    }
}
