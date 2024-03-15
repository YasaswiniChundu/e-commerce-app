package org.jsp.ecommerce.controller;

import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.model.User;
import org.jsp.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u) {
		return service.updateUser(u);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name="id") int id) {
		return service.findById(id);
	}
}
