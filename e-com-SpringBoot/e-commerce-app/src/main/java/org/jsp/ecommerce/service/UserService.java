package org.jsp.ecommerce.service;

import java.util.Optional;

import org.jsp.ecommerce.dao.UserDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.IdNotFoundException;
import org.jsp.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User u) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved...");
		structure.setData(dao.saveUser(u));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User u){
		Optional<User> user=dao.findById(u.getId());
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(user.isPresent()) {
			User users=user.get();
			users.setName(u.getName());
			users.setPhone(u.getPhone());
			users.setEmail(u.getEmail());
			structure.setMessage("User updated..");
			structure.setData(dao.saveUser(u));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		Optional<User> user=dao.findById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(user.isPresent()) {
			structure.setMessage("user found.....");
			structure.setData(user.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
