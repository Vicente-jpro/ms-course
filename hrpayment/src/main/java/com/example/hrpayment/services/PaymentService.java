package com.example.hrpayment.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrpayment.clients.WorkerClientResourse;
import com.example.hrpayment.entities.Payment;
import com.example.hrpayment.entities.Worker;
import com.example.hrpayment.exceptions.PaymentNotFoundException;
import com.example.hrpayment.repositories.PaymentRepository;
import com.example.hrpayment.utils.Calculo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final PaymentRepository paymentRepository;
    private final WorkerClientResourse workerClientResourse;

    public Payment salvar(Payment payment){
        return paymentRepository.save(payment); 
    }

    public String hello(){
        return workerClientResourse.hello();
    }

    public Payment getPaymentByIdWorker(Long idWorker, Integer days){
        log.info("Saving payment with worker id: {}", idWorker);
        Worker worker = workerClientResourse.getIdWorker(idWorker).getBody();

        Payment payment = new Payment();
        payment.setDailyIncome(worker.getDailyIncome());
        payment.setDays(days);
        payment.getTotal();
        payment.setName(worker.getName());
        BigDecimal day = BigDecimal.valueOf( Double.parseDouble(""+days));
        BigDecimal total = worker.getDailyIncome().multiply(day);
        
        payment.setTotal(total);
        return salvar(payment);
    
    }

    public List<Payment> listarTodos(){
        return this.paymentRepository.findAll();
    }

}
