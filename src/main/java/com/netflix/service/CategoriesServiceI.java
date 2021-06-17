/*
 * Categories's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;
import java.util.Set;

import com.netflix.exception.NetflixException;
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
	 * @throws NetflixException the netflix exception
	 */
	List<Categories> listAllCategories() throws NetflixException;

	
	/**
	 * List categories by ids.
	 *
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	Set<Categories> listCategoriesByIds(Set<Long> listCategoriesIds) throws NetflixException;
}
