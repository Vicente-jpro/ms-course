package com.example.hroauth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hroauth.entities.User;
import com.example.hroauth.services.OauthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthController {
    
    private final OauthService oauthService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
   
        return ResponseEntity.ok( oauthService.findUserById(id));
    }

    @GetMapping("/users/search")
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok( oauthService.findByEmail(email));
    }

    @GetMapping
    public String hello(){
        return "Hello from now oauthController";
    }

}
