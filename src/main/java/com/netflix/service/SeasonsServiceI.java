/*
 * Seasons's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

import com.netflix.exception.NetflixException;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.restModel.SeasonsRestModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeasonsServiceI.
 */
public interface SeasonsServiceI {
	
	/**
	 * List all seasons.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<SeasonsRestModel> listAllSeasons() throws NetflixException;
	
	/**
	 * Find by id.
	 *
	 * @param seriesId the series id
	 * @return the seasons
	 * @throws NetflixException the netflix exception
	 */
	SeasonsRestModel findById(Long tvShowId) throws NetflixException;
	
	/**
	 * Find by tv shows.
	 *
	 * @param tvshows the tvshows
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<SeasonsRestModel> findByTvShows(TvShows tvshows) throws NetflixException;
	
	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshows the tvshows
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	SeasonsRestModel findByTvShowsIdAndNumber(Long tvshowId,int seasonNumber)throws NetflixException; 

}
