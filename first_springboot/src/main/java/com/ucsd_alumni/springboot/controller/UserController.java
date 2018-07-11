package com.ucsd_alumni.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ucsd_alumni.springboot.model.User;
import com.ucsd_alumni.springboot.model.UserResponse;

@RestController
@RequestMapping("/service")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    
    /**
     * Test with curl command
     * 
     * curl -i -v -X POST -H "Content-Type: application/json;charset=UTF-8" http://localhost:8080/service/user -d '{"name":"foo","id":100}' 
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, 
            consumes = "application/json;charset=UTF-8", 
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> user(@RequestBody User user, 
            HttpServletRequest request) {
        LOG.info("Received user info: " + user.toString());
        return new ResponseEntity<Object>(new UserResponse("Received User Info"), 
                HttpStatus.OK);
    }
}
