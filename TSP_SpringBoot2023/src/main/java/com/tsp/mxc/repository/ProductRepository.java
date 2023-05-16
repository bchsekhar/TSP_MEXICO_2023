package com.tsp.mxc.repository;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.tsp.mxc.entity.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {


	List<Product> list;

	{



		list=Arrays.asList(new Product(1, "Iphone15", 50000),new Product(2, "SamsungA100",40000),new Product(3, "Nokia45", 3000));
	}



	public List<Product> showAll(){


		return list;
	}


	public Product findProduct(int id) {

		list=Arrays.asList(new Product(1, "Iphone15", 50000),new Product(2, "SamsungA100",40000),new Product(3, "Nokia45", 3000));
		Product product1=null;
		for(Product product:list) {

			if(product.getProductId()==id) {

				product1= product;
				break;

			}
			else
				product1=null;;

		}
		return product1;

	}
}
