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
        User us = findUserById(idUser);

        us.setId(us.getId());
        return this.userRepository.save(user); 
    }

    public void eliminar(Long idUser){
        log.info("fatching user with id: {}", idUser);

        User worker = findUserById(idUser);
        this.userRepository.deleteById(worker.getId());
    }

    public User findUserById(Long idUser){
        log.info("fatching user with id: {}", idUser);

        User worker = userRepository.findUserById(idUser);
        if (worker == null ){
            log.info("User do not exist: {}", idUser);
            throw new UserNotFoundException("User do not exist: "+ idUser);
        }

        return worker;
    }

    public User findByEmail(String email){
        log.info("fatching user with email: {}", email);

        User user = userRepository.findByEmail(email);
        if (user == null ){
            log.info("User do not exist: {}", email);
            throw new UserNotFoundException("User do not exist: "+ email);
        }

        return user;
    }



}
