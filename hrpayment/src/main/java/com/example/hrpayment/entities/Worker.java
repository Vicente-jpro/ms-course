package com.example.hrpayment.entities;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Worker {
    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
