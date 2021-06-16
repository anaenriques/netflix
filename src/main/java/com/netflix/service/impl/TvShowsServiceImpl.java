/*
 * TvShows's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
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



	// TODO: Auto-generated Javadoc
/**
	 * The Class TvShowsServiceImpl.
	 */
	@Service
	@Qualifier("TvShowsServiceImpl")
	public class TvShowsServiceImpl implements TvShowsServiceI{
	 
	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;
	
	/** The categories repository. */
	@Autowired
	@Qualifier("CategoriesRepository")
	private CategoriesRepository categoriesRepository;
	

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@Override
	public List<TvShows> findByCategoryId(Long categoryId) {
		return tvShowsRepository.findByCategoryId(categoriesRepository.findById(categoryId).get());
	}
	
	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	@Override
	public TvShows findById (Long tvShowId){
		return tvShowsRepository.findById(tvShowId).get();
	}

	@Override
	public TvShows updateTvShows(TvShows tvShow) {
		return tvShowsRepository.save(tvShow);
	}
	
}
