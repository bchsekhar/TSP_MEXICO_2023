package com.tsp.mxc.controller;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.mxc.entity.Product;
import com.tsp.mxc.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@GetMapping("findproducts")//product/findproducts
	//@RequestMapping(value="findproducts",method = RequestMethod.GET)
	List<Product> displayAll(){
		
		
		return productRepository.showAll();
		
		
		
	}
	
	
	
	@GetMapping("checkproduct/{id}/{name}")
	Product findProduct(@PathVariable int id,@PathVariable String name) {
		
		
		return productRepository.findProduct(id);
		
		
	}

	
	
	@GetMapping("chkpro")
	Product findPro(@PathParam("id") int id,@PathParam("name") String name) {
		
		System.out.println(name);
		return productRepository.findProduct(id);
		
		
	}
	
	@PostMapping("addpro")
	Product saveProduct(@RequestBody Product product) {
		
		
		return product;
	}
	
	
	
	@DeleteMapping("del/{id}")
	String deletePro(@PathVariable int id) {
		
		return id+" deleted";
		
	}
	
	
	@PutMapping("update/{id}")
	Product update(@RequestBody Product product,@PathVariable int id) {
		
		return product;
		
	}
}
