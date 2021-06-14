package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Categories;
import com.netflix.repository.CategoriesRepository;
import com.netflix.service.CategoriesServiceI;


	@Service
	@Qualifier("CategoriesServiceImpl")
	public class CategoriesServiceImpl implements CategoriesServiceI{
	 
	@Autowired
	@Qualifier("CategoriesRepository")
	private CategoriesRepository categoriesRepository;
	
	@Override
	public List<Categories> listAllCategories() {
		return categoriesRepository.findAll();
	}
}
