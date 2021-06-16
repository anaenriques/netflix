/*
 * Categories's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;
import java.util.Set;

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

	
	/**
	 * List categories by ids.
	 *
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 */
	Set<Categories> listCategoriesByIds(Set<Long> listCategoriesIds);
}
