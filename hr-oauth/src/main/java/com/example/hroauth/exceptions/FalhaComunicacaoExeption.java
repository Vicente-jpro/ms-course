package com.example.hroauth.exceptions;

import lombok.Getter;

public class FalhaComunicacaoExeption extends RuntimeException {


    private static final long serialVersionUID = 1L;
    
    @Getter
    private int status;

    public FalhaComunicacaoExeption(String message, int status){
        super(message);
        this.status = status;
    }
}
