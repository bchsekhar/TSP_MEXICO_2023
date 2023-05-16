package com.tsp.mxc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tsp.mxc.entity.Product;
@Repository
public interface ProRepository extends CrudRepository<Product, Integer>{
	List<Product> findByProductNameOrPrice(String name,float price);//custom automation
	//select * from product where name=mobile and price=1000


	List<Product> findAllsByPrice(float price);

	List<Product> findAllByPriceBetween(float st,float en);

	@Query("select pro from Product pro where pro.productId=:id")
	Product checkById(@Param("id") int id);


}
