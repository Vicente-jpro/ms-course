package com.example.hrworkers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workers")
public class WorkerController {
    

    @GetMapping
    public String hello(){
        return "Hello from spring boot";
    }
}
