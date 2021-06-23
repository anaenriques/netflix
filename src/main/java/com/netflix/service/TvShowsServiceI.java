/*
 * TvShows's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;
import java.util.Set;

import com.netflix.exception.NetflixException;
import com.netflix.model.TvShows;
import com.netflix.restModel.TvShowsRestModel;


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
	 * @throws NetflixException the netflix exception
	 */
	List<TvShowsRestModel> findByCategoryId(Long categoryId) throws NetflixException;
	
	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws NetflixException the netflix exception
	 */
	TvShowsRestModel findById(Long tvShowId)throws NetflixException;
	
	/**
	 * Adds the category.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv shows rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowsRestModel addCategory(Long tvShowId, Set<Long> listCategories)throws NetflixException;
	
	/**
	 * Update tv show.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws NetflixException the netflix exception
	 */
	TvShowsRestModel updateTvShows(Long tvShowId)throws NetflixException;
	
	/**
	 * Update tv show name.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the tv shows rest model
	 * @throws NetflixException the netflix exception
	 */
	TvShowsRestModel updateTvShowName(Long tvShowId, String tvShowName)throws NetflixException;
}
