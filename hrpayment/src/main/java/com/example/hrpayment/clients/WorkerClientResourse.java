package com.example.hrpayment.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hrpayment.entities.Worker;

@Component
@FeignClient(name = "hrworkers", path = "/workers")
public interface WorkerClientResourse {

    @GetMapping("/{id_worker}")
    ResponseEntity<Worker> getIdWorker(@PathVariable("id_worker") Long idWorker);
    
}
