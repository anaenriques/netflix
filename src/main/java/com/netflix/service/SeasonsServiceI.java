package com.netflix.service;

import java.util.List;

import com.netflix.model.Seasons;

public interface SeasonsServiceI {
	
	List<Seasons> listAllSeasons();
	List<Seasons> findSeasonByTvShowId(Long tvShowId);
}
