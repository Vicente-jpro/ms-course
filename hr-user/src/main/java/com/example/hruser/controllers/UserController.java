package com.example.hruser.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Users")
public class UserController {
    
    @GetMapping
    public String hello(){
        return "Hello from user controller";
    }
}
