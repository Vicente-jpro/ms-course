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

    public Payment atualizar(Payment payment, Long idWorker){
        Payment paymentSaved = getIdWorker(idWorker);

        payment.setId(paymentSaved.getId());
        return this.paymentRepository.save(payment); 
    }

    public void eliminar(Long idPayment){
        log.info("fatching worker with id: {}", idPayment);

        Payment paym = getIdWorker(idPayment);
        this.paymentRepository.deleteById(paym.getId());
    }

    public Payment getIdWorker(Long idPayment){
        log.info("fatching worker with id: {}", idPayment);

        Payment payment = paymentRepository.findPaymentById(idPayment);
        if (payment == null ){
            log.info("Worker do not exist: {}", idPayment);
            throw new PaymentNotFoundException("Worker do not exist: "+ idPayment);
        }

        return payment;
    }

    public List<Payment> listarTodos(){
        return this.paymentRepository.findAll();
    }

}
