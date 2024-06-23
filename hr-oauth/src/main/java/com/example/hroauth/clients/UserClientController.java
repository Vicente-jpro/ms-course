package com.example.hroauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hroauth.entities.User;

@FeignClient(name = "hrusers", path = "/users" ) 
public interface UserClientController {

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable("id") Long id);

    @GetMapping("/search")
    ResponseEntity<User> findByEmail(@RequestParam("email") String email);

}
