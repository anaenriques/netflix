package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Categories;
import com.netflix.model.TvShows;
import com.netflix.repository.CategoriesRepository;
import com.netflix.repository.TvShowsRepository;
import com.netflix.service.CategoriesServiceI;
import com.netflix.service.TvShowsServiceI;



	@Service
	@Qualifier("TvShowsServiceImpl")
	public class TvShowsServiceImpl implements TvShowsServiceI{
	 
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;
	
	@Autowired
	@Qualifier("CategoriesRepository")
	private CategoriesRepository categoriesRepository;
	

	@Override
	public List<TvShows> findByCategoryId(Long categoryId) {
		return tvShowsRepository.findByCategoryId(categoriesRepository.findById(categoryId).get());
	}
	
	@Override
	public TvShows findById (Long tvShowId){
		return tvShowsRepository.findById(tvShowId).get();
	}
	
}
