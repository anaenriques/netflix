/*
 * Seasons's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.repository.SeasonsRepository;
import com.netflix.repository.TvShowsRepository;
import com.netflix.service.SeasonsServiceI;


	// TODO: Auto-generated Javadoc
/**
	 * The Class SeasonsServiceImpl.
	 */
	@Service
	@Qualifier("SeasonsServiceImpl")
    public class SeasonsServiceImpl implements SeasonsServiceI{
	 
	/** The seasons repository. */
	@Autowired
	@Qualifier("SeasonsRepository")
	private SeasonsRepository seasonsRepository;
	
	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;
	
	/**
	 * List all seasons.
	 *
	 * @return the list
	 */
	@Override
	public List<Seasons> listAllSeasons() {
		return seasonsRepository.findAll();
	}
	
	/**
	 * Find by id.
	 *
	 * @param seriesId the series id
	 * @return the seasons
	 */
	@Override
	public Seasons findById (Long seriesId){
		return seasonsRepository.findById(seriesId).get();
	}

	/**
	 * Find by tv shows.
	 *
	 * @param tvshows the tvshows
	 * @return the list
	 */
	@Override
	public List<Seasons> findByTvShows(TvShows tvshows) {
		return seasonsRepository.findByTvShows(tvshows);
	}
	
	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshows the tvshows
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<Seasons> findByTvShowsAndNumber(TvShows tvshows, int seasonNumber) {
		return seasonsRepository.findByTvShowsAndNumber(tvshows,seasonNumber);
	}
	
	
	
}
