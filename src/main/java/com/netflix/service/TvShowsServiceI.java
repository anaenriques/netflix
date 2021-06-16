/*
 * TvShows's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

import com.netflix.model.TvShows;


// TODO: Auto-generated Javadoc
/**
 * The Interface TvShowsServiceI.
 */
public interface TvShowsServiceI {
	
	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	List<TvShows> findByCategoryId(Long categoryId);
	
	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	TvShows findById(Long tvShowId);
}
