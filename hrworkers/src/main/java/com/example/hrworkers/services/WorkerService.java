package com.example.hrworkers.services;

import org.springframework.stereotype.Service;

import com.example.hrworkers.entities.Worker;
import com.example.hrworkers.exceptions.WorkerNotFoundException;
import com.example.hrworkers.repositories.WorkerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerService {
    
    private final WorkerRepository workerRepository;

    public Worker salvar(Worker worker){
        return workerRepository.save(worker); 
    }

    public Worker atualizar(Worker worker, Long idWorker){
        Worker wk = getIdWorker(idWorker);

        worker.setId(wk.getId());
        return this.workerRepository.save(worker); 
    }

    public void eliminar(Long idWorker){
        log.info("fatching worker with id: {}", idWorker);

        Worker worker = getIdWorker(idWorker);
        this.workerRepository.deleteById(worker.getId());
    }

    public Worker getIdWorker(Long idWorker){
        log.info("fatching worker with id: {}", idWorker);

        Worker worker = workerRepository.findWorkerById(idWorker);
        if (worker == null ){
            log.info("Worker do not exist: {}", idWorker);
            throw new WorkerNotFoundException("Worker do not exist: "+ idWorker);
        }

        return worker;
    }


}
