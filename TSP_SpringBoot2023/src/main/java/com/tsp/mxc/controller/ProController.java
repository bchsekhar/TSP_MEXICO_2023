package com.tsp.mxc.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.mxc.entity.Product;
import com.tsp.mxc.repository.ProRepository;
import com.tsp.mxc.repository.ProductRepository;
import com.tsp.mxc.service.ProductServiceImpl;

@RestController
@RequestMapping("pro")
public class ProController {


	@Autowired
	ProductServiceImpl productServiceImpl;


	@PostMapping("save")
	Product saveProduct(@RequestBody Product product) {


		return productServiceImpl. saveProduct(product);

	}

	@GetMapping("all")
	List<Product> displayAll(){

		return (List<Product>) productServiceImpl.findAll();
	}
	@GetMapping("checkpr")
	Product getProduct(@PathParam("id") int id) {

		return productServiceImpl.findById(id);

	}

	@DeleteMapping("del/{id}")
	String delete(@PathVariable int id) {


		;
		return productServiceImpl.delete(id);
	}

	@GetMapping("chkname/{name}/{price}")
	List<Product> checkProduct(@PathVariable String name,@PathVariable float price) {


		return productServiceImpl.checkProduct(name,price);

	}
	@GetMapping("chkprice/{price1}/{price2}")
	List<Product> checkProductBetween(@PathVariable float price1,@PathVariable float price2) {


		return productServiceImpl.checkProductBetween(price1,price2);

	}
	
	
	
	@GetMapping("custman/{id}")
	Product findById(@PathVariable int id) {
		
		//Optional<Product> optional=Optional.ofNullable(null)
		
		
		return productServiceImpl.findById(id);
	}
}
