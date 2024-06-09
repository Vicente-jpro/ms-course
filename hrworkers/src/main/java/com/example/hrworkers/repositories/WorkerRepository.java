package com.example.hrworkers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrworkers.entities.Worker;
import java.util.List;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

 Worker findWorkerById(Long id);
}