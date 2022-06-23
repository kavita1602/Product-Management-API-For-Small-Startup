package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.model.product;
import com.javaguides.springboot.service.ProductService;
@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<product>>getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	@GetMapping("/getproducts/{id}")
	public ResponseEntity<product> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
	
	
	@PostMapping("/postProducts")
	public ResponseEntity<product>createProduct(@RequestBody product product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}
	
	@PutMapping("/putProducts/{id}")
		public ResponseEntity<product> updateProduct(@PathVariable long id, @RequestBody product product){
			product.setId(id);
			return ResponseEntity.ok().body(this.productService.updateProduct(product));
		}
		
		@DeleteMapping("/deletProducts/{id}")	
		public HttpStatus deletProduct(@PathVariable long id){
			this.productService.deletProduct(id);
			return HttpStatus.OK;
		}
			
			
		
	}


