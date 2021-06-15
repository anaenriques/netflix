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


	@Service
	@Qualifier("SeasonsServiceImpl")
    public class SeasonsServiceImpl implements SeasonsServiceI{
	 
	@Autowired
	@Qualifier("SeasonsRepository")
	private SeasonsRepository seasonsRepository;
	
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;
	
	@Override
	public List<Seasons> listAllSeasons() {
		return seasonsRepository.findAll();
	}
	
	@Override
	public Seasons findById (Long seriesId){
		return seasonsRepository.findById(seriesId).get();
	}

	@Override
	public List<Seasons> findByTvShows(TvShows tvshows) {
		return seasonsRepository.findByTvShows(tvshows);
	}
	
	@Override
	public List<Seasons> findByTvShowsAndNumber(TvShows tvshows, int seasonNumber) {
		return seasonsRepository.findByTvShowsAndNumber(tvshows,seasonNumber);
	}
	
	
	
}
