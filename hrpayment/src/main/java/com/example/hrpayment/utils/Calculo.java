package com.example.hrpayment.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Calculo {
    
    private Calculo(){

    }

    public static BigDecimal multiplicacao(BigDecimal num1, BigDecimal num2){
        return num1.multiply(num2);
    }
}
