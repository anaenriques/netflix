/*
 * Categories's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

import com.netflix.model.Categories;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoriesServiceI.
 */
public interface CategoriesServiceI {
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	List<Categories> listAllCategories();
}
