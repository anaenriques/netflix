package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.service.SeasonsServiceI;


@RestController
public class SeasonController {
	
	@Autowired
	@Qualifier("SeasonsServiceImpl")
	private SeasonsServiceI seasonService;
	
	
	@GetMapping("/series/{seriesId}/seasons")
	public List<Seasons> listSeasonsById(@PathVariable Long seriesId) {
		final TvShows tvShows = new TvShows();
		tvShows.setId(seriesId);
		return seasonService.findByTvShows(tvShows);
	}
	
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}")
	public List<Seasons> listTvShowsAndNumber(@PathVariable Long seriesId, @PathVariable int seasonNumber) {
		final TvShows tvShows = new TvShows();
		tvShows.setId(seriesId);
		return seasonService.findByTvShowsAndNumber(tvShows,seasonNumber);
	}
	

	

}
