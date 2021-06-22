/*
 * TvShows's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

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
	 * @throws Exception 
	 */
	TvShowsRestModel findById(Long tvShowId)throws NetflixException;
	
	/**
	 * Update tv show.
	 *
	 * @param tvShow the tv show
	 * @return the tv shows
	 * @throws NetflixException the netflix exception
	 */
	TvShowsRestModel updateTvShows(Long tvShowId)throws NetflixException;
}
