package org.jsp.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerce.dao.MerchantDao;
import org.jsp.ecommerce.dao.ProductDao;
import org.jsp.ecommerce.dto.ResponseStructure;
import org.jsp.ecommerce.exception.IdNotFoundException;
import org.jsp.ecommerce.exception.ProductNotFoundException;
import org.jsp.ecommerce.model.Merchant;
import org.jsp.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product p,int merchant_id) {
		Optional<Merchant>m=merchantDao.findById(merchant_id);
		if(m.isPresent()) {
			Merchant merchant=m.get();
			merchant.getProducts().add(p);
			p.setMerchant(merchant);
		ResponseStructure<Product> structure=new ResponseStructure<>();
		structure.setMessage("Product saved...");
		structure.setData(dao.saveproduct(p));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product p){
		Optional<Product> pr=dao.findById(p.getId());
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(pr.isPresent()) {
			Product product=pr.get();
			product.setName(p.getName());
			product.setBrand(p.getBrand());
			product.setCategory(p.getCategory());
			product.setDescrp(p.getDescrp());
			product.setImage_url(p.getImage_url());
			product.setCost(p.getCost());
			structure.setMessage("Product updated...");
			structure.setData(dao.saveproduct(p));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Product>> findById(int id){
		Optional<Product> pr=dao.findById(id);
		ResponseStructure<Product> structure=new ResponseStructure<>();
		if(pr.isPresent()) {
			structure.setMessage("Product found");
			structure.setData(pr.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	

	public ResponseEntity<ResponseStructure<List<Product>>> findAll()
	{
		List<Product> products=dao.findAll();
		if(products.isEmpty())
		{
		 throw new ProductNotFoundException("Products not found");	
		}
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		structure.setData(products);
		structure.setMessage("List of products found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand)
	{
		List<Product> products=dao.findByBrand(brand);
		if(products.isEmpty())
		{
		 throw new ProductNotFoundException("Products not found with entered Brand");	
		}
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		structure.setData(products);
		structure.setMessage("List of products found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(String category)
	{
		List<Product> products=dao.findByCategory(category);
		if(products.isEmpty())
		{
		 throw new ProductNotFoundException("Products not found with entered Catgeory");	
		}
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		structure.setData(products);
		structure.setMessage("List of products found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(int id)
	{
		List<Product> products=dao.findByMerchantId(id);
		if(products.isEmpty())
		{
		 throw new ProductNotFoundException("Products not found with entered Merchant_Id");	
		}
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		structure.setData(products);
		structure.setMessage("List of products found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
}
