package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.TvShows;
import com.netflix.service.TvShowsServiceI;

@RestController
public class TvShowsController {
	
	@Autowired
	@Qualifier("TvShowsServiceImpl")
	
	private TvShowsServiceI tvShowsService;
	
	@GetMapping("/listAllShowsCategories/{categoryId}")
	public List<TvShows> listTvShowsByName(@PathVariable Long categoryId) {
		return tvShowsService.findByCategoryId(categoryId);
	}
	
}
