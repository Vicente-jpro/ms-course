package com.example.hrpayment.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table( name = "workers")
public class Payment implements Serializable{

    private static final long serialVersionUID = 1L; 

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column( name = "daily_income")
    private BigDecimal dailyIncome;

    @Column( name = "days")
    private BigDecimal days;

    @Column( name = "total")
    private BigDecimal total;
    
}
