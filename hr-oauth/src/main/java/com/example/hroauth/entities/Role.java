package com.example.hroauth.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role{
    
    private Long id;
    private String role;

}
