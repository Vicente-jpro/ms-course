package com.example.hrusers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrusers.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

 User findUserById(Long id);
}