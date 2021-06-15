package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Categories;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.repository.CategoriesRepository;
import com.netflix.repository.SeasonsRepository;
import com.netflix.repository.TvShowsRepository;
import com.netflix.service.CategoriesServiceI;
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
	public List<Seasons> findSeasonByTvShowId(Long tvShowId) {   
		return seasonsRepository.findSeasonByTvShows(tvShowsRepository.findById(tvShowId).get());
	}
}
