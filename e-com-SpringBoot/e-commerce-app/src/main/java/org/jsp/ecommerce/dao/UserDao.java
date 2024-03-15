package org.jsp.ecommerce.dao;

import java.util.Optional;

import org.jsp.ecommerce.model.User;
import org.jsp.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User u) {
		return repository.save(u);
	}
	
	public User updateUser(User u) {
		return repository.save(u);
	}
	
	public Optional<User> findById(int id){
		return repository.findById(id);
	}
	
}
