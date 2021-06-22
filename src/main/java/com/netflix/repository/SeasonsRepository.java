/*
 * Seasons's Repository
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.netflix.model.Seasons;
import com.netflix.model.TvShows;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeasonsRepository.
 */
@Repository
@Qualifier("SeasonsRepository")
public interface SeasonsRepository  extends JpaRepository<Seasons, Long>{
	
	/**
	 * Find by tv shows.
	 *
	 * @param tvShow the tv show
	 * @return the list
	 */
	List<Seasons> findByTvShows(TvShows tvShow);
	
	/**
	 * Find by tv shows and number.
	 *
	 * @param tvShow the tv show
	 * @param seasonNumber the season number
	 * @return the list
	 */
	Seasons findByTvShowsIdAndNumber(Long tvShowId, int seasonNumber);
}
