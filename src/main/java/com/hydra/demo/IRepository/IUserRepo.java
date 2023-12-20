package com.hydra.demo.IRepository;



import com.hydra.demo.document.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
//    User findByName(String username);


    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
