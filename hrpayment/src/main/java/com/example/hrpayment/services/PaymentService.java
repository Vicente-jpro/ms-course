package com.example.hrpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrpayment.entities.Payment;
import com.example.hrpayment.exceptions.PaymentNotFoundException;
import com.example.hrpayment.repositories.PaymentRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final PaymentRepository paymentRepository;

    public Payment salvar(Payment payment){
        return paymentRepository.save(payment); 
    }

    public Payment getPaymentByIdWorker(Long idWorker, Integer days){
        log.info("fatching worker with id: {}", idWorker);

        Payment payment = paymentRepository.findPaymentById(idWorker);
        if (payment == null ){
            log.info("Worker do not exist: {}", idWorker);
            throw new PaymentNotFoundException("Worker do not exist: "+ idWorker);
        }

        return payment;
    }

    public List<Payment> listarTodos(){
        return this.paymentRepository.findAll();
    }

}
