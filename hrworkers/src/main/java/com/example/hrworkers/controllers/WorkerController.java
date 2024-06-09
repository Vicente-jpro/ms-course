package com.example.hrworkers.controllers;

import org.springframework.http.HttpStatus;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("workers")
public class WorkerController {

    private final WorkerService workerService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Worker salvar(@RequestBody Worker worker){
        return workerService.salvar(worker);
    }

    @PatchMapping("/{id_worker}")
    @ResponseStatus(HttpStatus.OK)
    public Worker atualizar(@RequestBody Worker worker,  @PathVariable("id_worker") Long idWorker){
        return this.workerService.atualizar(worker, idWorker);
    }

    @DeleteMapping("/{id_worker}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminar(@PathVariable("id_worker") Long idWorker){
        this.eliminar(idWorker);
    }

    @GetMapping("/{id_worker}")
    @ResponseStatus(HttpStatus.OK)
    public Worker getIdWorker(@PathVariable("id_worker") Long idWorker){
      
        return this.workerService.getIdWorker(idWorker);
    }
}
