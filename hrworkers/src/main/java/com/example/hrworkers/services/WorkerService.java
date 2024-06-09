package com.example.hrworkers.services;

import org.springframework.stereotype.Service;

import com.example.hrworkers.entities.Worker;
import com.example.hrworkers.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {
    
    private final WorkerRepository workerRepository;

    public Worker salvar(Worker worker){
        return workerRepository.save(worker); 
    }

    public Worker atualizar(Worker worker, Long id){
        return 
    }


    public Worker getIdWorker(Long id){


        return 
    }


}
