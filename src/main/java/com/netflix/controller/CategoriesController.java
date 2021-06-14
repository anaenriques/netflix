package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.Categories;
import com.netflix.service.CategoriesServiceI;


@RestController
public class CategoriesController {
	
	@Autowired
	@Qualifier("CategoriesServiceImpl")
	
	private CategoriesServiceI categoriesService;
	
	@GetMapping("/listAllCategories")
	public List<Categories> listAllCategories() {
		return categoriesService.listAllCategories();
	}
	

}
