package com.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.dao.ProductRepository;
import com.product_service.model.Product;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository prrepo;
	
	public List<Product> findall(){
		return (List<Product>) prrepo.findAll();
	}
	
	public Product findByName(String pname) {
		return prrepo.findByPname(pname).
				orElseThrow(()->new RuntimeException("Product not found"));
				
	}
	
	public Product saveProduct(Product p) {
		return prrepo.save(p);
	}
	
	public Product updateProduct(int pid, Product pr) {
		Product existing=prrepo.findById(pid).orElseThrow(()->new RuntimeException("No Product Avilable with ID:"+pid));
		if(pr.getPname()!=null)
			existing.setPname(pr.getPname());
		if(pr.getPrice()!=null)
			existing.setPrice(pr.getPrice());
		if(pr.getQuantity()!=null)
			existing.setQuantity(pr.getQuantity());
		
		return prrepo.save(existing);
		
	}
	
	public String deleteProduct(int pid) {
		Product existing=prrepo.findById(pid).orElseThrow(()->new RuntimeException("No Product Avilable with ID::"+pid));
		prrepo.deleteById(pid);
		return "Product Deleted";
	}
		
	
}
