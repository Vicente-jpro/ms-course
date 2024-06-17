package com.example.hrusers.services;

import org.springframework.stereotype.Service;

import com.example.hrusers.entities.User;
import com.example.hrusers.exceptions.UserNotFoundException;
import com.example.hrusers.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User salvar(User user){
        return userRepository.save(user); 
    }

    public User atualizar(User user, Long idUser){
        User us = getIdWorker(idUser);

        us.setId(us.getId());
        return this.userRepository.save(user); 
    }

    public void eliminar(Long idUser){
        log.info("fatching user with id: {}", idUser);

        User worker = getIdWorker(idUser);
        this.userRepository.deleteById(worker.getId());
    }

    public User getIdWorker(Long idUser){
        log.info("fatching worker with id: {}", idUser);

        User worker = userRepository.findUserById(idUser);
        if (worker == null ){
            log.info("Worker do not exist: {}", idUser);
            throw new UserNotFoundException("Worker do not exist: "+ idUser);
        }

        return worker;
    }


    public User (Long idUser){
        log.info("fatching worker with id: {}", idUser);

        User worker = userRepository.findUserById(idUser);
        if (worker == null ){
            log.info("Worker do not exist: {}", idUser);
            throw new UserNotFoundException("Worker do not exist: "+ idUser);
        }

        return worker;
    }


}
