/*
 * Categories's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.exception.NetflixException;
import com.netflix.model.Categories;
import com.netflix.repository.CategoriesRepository;
import com.netflix.service.CategoriesServiceI;



	// TODO: Auto-generated Javadoc
/**
	 * The Class CategoriesServiceImpl.
	 */
	@Service
	@Qualifier("CategoriesServiceImpl")
	public class CategoriesServiceImpl implements CategoriesServiceI{
	 
	/** The categories repository. */
	@Autowired
	@Qualifier("CategoriesRepository")
	private CategoriesRepository categoriesRepository;
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 */
	@Override
	public List<Categories> listAllCategories() throws NetflixException{
		return categoriesRepository.findAll();
	}
	
	
	@Override
	public Set<Categories> listCategoriesByIds(Set<Long> listCategoriesIds) throws NetflixException{
		return new HashSet<>(categoriesRepository.findAllById(listCategoriesIds));
	}
}
