package com.example.hrworkers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrworkers.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Long, Worker>{

}