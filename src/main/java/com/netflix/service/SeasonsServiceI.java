package com.netflix.service;

import java.util.List;

import com.netflix.model.Seasons;
import com.netflix.model.TvShows;

public interface SeasonsServiceI {
	
	List<Seasons> listAllSeasons();
	Seasons findById(Long seriesId);
	List<Seasons> findByTvShows(TvShows tvshows);
	List<Seasons> findByTvShowsAndNumber(TvShows tvshows,int seasonNumber); 

}
