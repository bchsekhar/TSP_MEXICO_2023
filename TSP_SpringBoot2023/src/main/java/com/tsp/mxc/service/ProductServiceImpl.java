package com.tsp.mxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsp.mxc.entity.Product;
import com.tsp.mxc.repository.ProRepository;
@Service
public class ProductServiceImpl implements IProductService{


	@Autowired
	ProRepository proRepository;
	@Override
	public Product saveProduct(Product product) {
		if(product!=null)

			return proRepository.save(product);
		else return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return (List<Product>) proRepository.findAll();
	}

	@Override
	public List<Product> checkProduct(String name, float price) {
		// TODO Auto-generated method stub
		return proRepository.findByProductNameOrPrice(name, price);
	}

	@Override
	public List<Product> checkProductBetween(float price1, float price2) {
		// TODO Auto-generated method stub
		return proRepository.findAllByPriceBetween(price1, price2);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return proRepository.checkById(id);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		Product product=findById(id);
		if(product!=null) {
			proRepository.delete(product);
			return "deleted"+id;

		}
		else
			return id+" is wrong id";
	}

}
