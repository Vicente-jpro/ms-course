package com.example.hroauth.services;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.hroauth.clients.UserClientController;
import com.example.hroauth.entities.User;
import com.example.hroauth.exceptions.FalhaComunicacaoExeption;
import com.example.hroauth.exceptions.UserNotFoundException;


import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OauthService {
    
    private final UserClientController userClientController;

    public User findUserById(Long idUser)throws UserNotFoundException, FalhaComunicacaoExeption{
        log.info("Buscando o usuario pelo ID: {}", idUser);
        try {
            User user = userClientController.findById(idUser).getBody();
            return user;    
        } catch (FeignException e) {
            int status = e.status();
            
            if (HttpStatus.SC_BAD_REQUEST == status){
                log.error("Usuario nao encontrado: {}", idUser);
                throw new UserNotFoundException("Usuario nao encontrado: "+idUser, status);

            }else if(HttpStatus.SC_NOT_FOUND == status){
                log.error("Requisicao invalida. Pagina nao encontrada");
                throw new UserNotFoundException("Requisicao invalida. Pagina nao encontrada", status);
            }
           
            log.error("Falha na comunicacao com o servico de Users.");
            e.printStackTrace();
            throw new FalhaComunicacaoExeption("Falha na comunicacao com o servico de Users.", status);
        }
        
    }

    public User findByEmail(String email){
        User user = userClientController.findByEmail(email).getBody();
       return user;
    }

}
