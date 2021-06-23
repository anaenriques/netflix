/*
 * Categories's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.exception.NetflixException;
import com.netflix.exception.NotFoundException;
import com.netflix.model.Categories;
import com.netflix.repository.CategoriesRepository;
import com.netflix.restModel.CategoriesRestModel;
import com.netflix.service.CategoriesServiceI;
import com.netflix.utils.constants.ExceptionConstants;



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
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * List all categories.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<CategoriesRestModel> listAllCategories() throws NetflixException{

		List<Categories> categories=categoriesRepository.findAll();
		if (categories.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY);
		}
		return categories.stream().map(category -> modelMapper.map(category, CategoriesRestModel.class)).collect(Collectors.toList());
	}
	
	
	/**
	 * List categories by ids.
	 *
	 * @param listCategoriesIds the list categories ids
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Set<Categories> listCategoriesByIds(Set<Long> listCategoriesIds) throws NetflixException{
		
		Set<Categories> categories=new HashSet<>(categoriesRepository.findAllById(listCategoriesIds));
		
		if (categories.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY);
		}
		return categories;
	}
}
