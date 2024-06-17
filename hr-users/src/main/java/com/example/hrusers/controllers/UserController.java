package com.example.hrusers.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrusers.entities.User;
import com.example.hrusers.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    
    
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok( userService.findUserById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok( userService.findByEmail(email));
    }
}
