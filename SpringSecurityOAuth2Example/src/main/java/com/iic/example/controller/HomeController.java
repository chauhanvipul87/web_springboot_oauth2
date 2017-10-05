package com.iic.example.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iic.example.domain.User;
import com.iic.example.service.UserService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    
    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting home page");
        return "home";
    }
    
   
 
     
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> listAllUsers() {
        Collection<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<Collection<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }

}
