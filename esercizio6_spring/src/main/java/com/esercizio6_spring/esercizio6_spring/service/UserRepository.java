package com.esercizio6_spring.esercizio6_spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio6_spring.esercizio6_spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
