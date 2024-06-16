package com.example.hrworkers.controllers;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

import com.example.hrworkers.entities.Worker;
import com.example.hrworkers.services.WorkerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("workers")
public class WorkerController {

    private final WorkerService workerService;

    @Value("${test.config}")
    private String profileTest;

    @GetMapping("/hello")
    public String hello(){

        return "Hello from workers controller "+profileTest;
    }
    
    @PostMapping
    public ResponseEntity<Worker> salvar(@RequestBody Worker worker){
        return ResponseEntity.ok(workerService.salvar(worker));
    }

    @PatchMapping("/{id_worker}")
    public ResponseEntity<Worker>  atualizar(@RequestBody Worker worker,  @PathVariable("id_worker") Long idWorker){
        return ResponseEntity.ok(this.workerService.atualizar(worker, idWorker));
    }


    @GetMapping
    public ResponseEntity<List<Worker>> listarTodos(){
        return ResponseEntity.ok(this.workerService.listarTodos());
    }

    @DeleteMapping("/{id_worker}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id_worker") Long idWorker){
        this.eliminar(idWorker);
    }

    @GetMapping("/{id_worker}")
    public ResponseEntity<Worker> getIdWorker(@PathVariable("id_worker") Long idWorker){
   
        return ResponseEntity.ok(this.workerService.getIdWorker(idWorker)); 
    }
}
