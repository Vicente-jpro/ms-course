package com.example.hrpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrpayment.entities.Payment;
import com.example.hrpayment.services.PaymentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("payments")
public class PaymentController {

    private final PaymentService workerService;
    
    @PostMapping
    public ResponseEntity<Payment> salvar(@RequestBody Payment worker){
        return ResponseEntity.ok(workerService.salvar(worker));
    }

    @PatchMapping("/{id_worker}")
    public ResponseEntity<Payment>  atualizar(@RequestBody Payment worker,  @PathVariable("id_worker") Long idWorker){
        return ResponseEntity.ok(this.workerService.atualizar(worker, idWorker));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> listarTodos(){
        return ResponseEntity.ok(this.workerService.listarTodos());
    }

    @DeleteMapping("/{id_worker}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id_worker") Long idWorker){
        this.eliminar(idWorker);
    }

    @GetMapping("/{id_worker}")
    public ResponseEntity<Payment> getIdWorker(@PathVariable("id_worker") Long idWorker){
        return ResponseEntity.ok(this.workerService.getIdWorker(idWorker)); 
    }
}
