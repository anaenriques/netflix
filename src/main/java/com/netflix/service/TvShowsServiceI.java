package com.netflix.service;

import java.util.List;

import com.netflix.model.TvShows;


public interface TvShowsServiceI {
	
	List<TvShows> findByCategoryId(Long categoryId);
}
