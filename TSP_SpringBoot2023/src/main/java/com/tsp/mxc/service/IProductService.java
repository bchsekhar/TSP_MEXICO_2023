package com.tsp.mxc.service;

import java.util.List;


import com.tsp.mxc.entity.Product;

public interface IProductService {
	Product saveProduct(Product product);

	List<Product> findAll();

	List<Product> checkProduct( String name, float price) ;

	List<Product> checkProductBetween( float price1, float price2);
	Product findById( int id) ;
	String delete( int id) ;



}
