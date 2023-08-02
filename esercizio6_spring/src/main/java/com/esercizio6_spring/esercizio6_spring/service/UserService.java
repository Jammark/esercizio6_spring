package com.esercizio6_spring.esercizio6_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio6_spring.esercizio6_spring.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User save(User u) {

		return repo.save(u);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public Optional<User> findById(Long id) {

		return repo.findById(id);
	}

	public void rimuovi(User u) {
		repo.delete(u);
	}

}
