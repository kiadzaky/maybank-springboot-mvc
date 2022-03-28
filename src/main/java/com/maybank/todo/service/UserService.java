package com.maybank.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.todo.model.User;
import com.maybank.todo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repository;
	public List<User> listAllUsers(){
		return repository.findAll();
	}
	
	public void save (User user) {
		repository.save(user);
	}
	public User get(long id) {
		return repository.findById(id).get();
	}
	
	public void delete (long id) {
		repository.deleteById(id);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		User objUser = repository.findByUsernameAndPassword(username, password);
		return objUser;
	}
}
