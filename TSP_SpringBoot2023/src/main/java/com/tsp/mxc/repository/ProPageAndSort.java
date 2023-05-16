package com.tsp.mxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tsp.mxc.entity.Product;

public interface ProPageAndSort extends JpaRepository<Product, Integer>{

}
