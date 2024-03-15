package org.jsp.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.model.Product;
import org.jsp.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository repository;
	
	public Product saveproduct(Product product) { 
		return repository.save(product);
	}
	
	public Optional<Product> findById(int id){
		return repository.findById(id);
	}
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public List<Product> findByMerchantId(int merchant_id){
		return repository.findByMerchantId(merchant_id);
	}
	
	public List<Product> findByBrand(String brand){
		return repository.findByBrand(brand);
	}
	
	public List<Product> findByCategory(String category){
		return repository.findByCategory(category);
	}
}
