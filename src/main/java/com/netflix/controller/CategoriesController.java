/*
 * Categories Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.Categories;
import com.netflix.service.CategoriesServiceI;


// TODO: Auto-generated Javadoc
/**
 * The Class CategoriesController.
 */
@RestController
public class CategoriesController {
	
	/** The categories service. */
	@Autowired
	@Qualifier("CategoriesServiceImpl")
	
	private CategoriesServiceI categoriesService;
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	@GetMapping("/categories")
	public List<Categories> listAllCategories() {
		return categoriesService.listAllCategories();
	}
	
	
	
}
