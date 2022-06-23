package com.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.model.product;
import com.javaguides.springboot.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	
	@Autowired 
	private ProductRepository productRepository ;

	@Override
	public product createProduct(product product) {
		
		return productRepository.save(product);
	}

	@Override
	public product updateProduct(product product) {
		Optional<product> productDb = this.productRepository.findById(product.getId());
		
		if(productDb.isPresent()) {
			product productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}else {
			throw new ResourceNotFoundException("Record Not Found With id :"+product.getId());
		}
	
	}

	@Override
	public List<product> getAllProduct() {
		
		return this.productRepository.findAll();
	}

	@Override
	public product getProductById(long productId) {
     Optional<product> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
		  return productDb.get();
		}else {
			throw new ResourceNotFoundException("Record Not Found With id :"+productId);
		}
		
	}

	@Override
	public void deletProduct(long productId ) {
     Optional<product> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
		 this.productRepository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Record Not Found With id :"+productId);
		}
		
	}

}
