package org.jsp.ecommerce.dao;

import java.util.Optional;

import org.jsp.ecommerce.model.Address;
import org.jsp.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repository;
	
	public Address saveAddress(Address a) {
		return repository.save(a);
	}
	
	public Address updateAddress(Address a) {
		return repository.save(a);
	}
	
	public Optional<Address> findById(int id) {
		return repository.findById(id);
	}

}
