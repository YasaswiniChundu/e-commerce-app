package org.jsp.ecommerce.service;

import java.util.Optional;

import org.jsp.ecommerce.dao.AddressDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.IdNotFoundException;
import org.jsp.ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> addAddress(Address a) {
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setMessage("Address saved successfully....");
		structure.setData(dao.saveAddress(a));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address a){
		Optional<Address> add=dao.findById(a.getId());
		ResponseStructure<Address> structure=new ResponseStructure<>();
		if(add.isPresent()) {
			Address ad=add.get();
			ad.setStreet(a.getStreet());
			ad.setCity(a.getCity());
			ad.setLandmark(a.getLandmark());
			ad.setBuilding_name(a.getBuilding_name());
			ad.setState(a.getState());
			ad.setCountry(a.getCountry());
			ad.setPincode(a.getPincode());
			structure.setMessage("Address saved successfully....");
			structure.setData(dao.saveAddress(a));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Address>> findById(int id){
		Optional<Address> add=dao.findById(id);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		if(add.isPresent()) {
			structure.setMessage("Address found.....");
			structure.setData(add.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

}