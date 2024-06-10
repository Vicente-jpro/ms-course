package com.example.hrpayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrpayment.entities.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

    Payment findPaymentById(Long id);
}