package com.ucsd_alumni.springboot.model;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private Map<String, Object> error;

    /**
     * ErrorResponse Constructor.
     * Requires the integer value of the http status code and the error message
     * 
     * @param httpStatus
     * @param errorMessage
     */
    public ErrorResponse(int httpStatus, String errorMessage) {
        this.error = new HashMap<String, Object>();
        this.error.put("status", httpStatus);
        this.error.put("message", errorMessage);
    }

    /**
     * Returns the error map containing the status and message
     * 
     * @return Map<String, Object>
     */
    public Map<String, Object> getError() {
        return this.error;
    }
}
