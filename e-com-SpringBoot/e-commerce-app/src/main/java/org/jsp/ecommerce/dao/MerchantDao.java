package org.jsp.ecommerce.dao;

import java.util.Optional;

import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	@Autowired
	private MerchantRepository repository;
	
	public Merchant saveMerchant(Merchant m) {
		return repository.save(m);
	}
	
	public Merchant updateMerchant(Merchant m) {
		return repository.save(m);
	}
	
	public Optional<Merchant> findById(int id){
		return repository.findById(id);
	}
	
	public Optional<Merchant> verifyByPhone(long phone, String password){
		return repository.verify(phone, password);
	}
	
	public Optional<Merchant> verifyByEmail(String email, String password){
		return repository.verify(email, password);
	}
	
	public Optional<Merchant> findByToken(String token){
		return repository.findByToken(token);
	}
}
