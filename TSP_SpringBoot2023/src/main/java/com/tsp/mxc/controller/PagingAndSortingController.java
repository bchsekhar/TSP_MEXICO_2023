package com.tsp.mxc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsp.mxc.entity.Product;
import com.tsp.mxc.repository.ProPageAndSort;

@RestController
@RequestMapping("pagesort")
public class PagingAndSortingController {
	@Autowired
	ProPageAndSort proPageAndSort;

	@GetMapping("viewAllSort")
	List<Product> showAll(@RequestParam(defaultValue = "productId") String name){

		Sort sort=Sort.by(name).descending();
		return (List<Product>) proPageAndSort.findAll(sort);

	}


	@GetMapping(value="viewAllPage")
	List<Product> showAllPage(@RequestParam(defaultValue = "0") int pageNo ,@RequestParam(defaultValue = "1") int pageSize ,@RequestParam(defaultValue = "productId") String name){

		Sort sort=Sort.by(name);

		Pageable pageable=PageRequest.of(pageNo,pageSize,sort);

		Page<Product> page=  proPageAndSort.findAll(pageable);
		if(page.hasContent())
			return page.getContent();
		else
			return new ArrayList<Product>();




	}



}
