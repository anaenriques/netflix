package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.Seasons;
import com.netflix.service.SeasonsServiceI;


@RestController
public class SeasonController {
	
	@Autowired
	@Qualifier("SeasonsServiceImpl")
	
	private SeasonsServiceI seasonService;
	
	@GetMapping("/listAllSeason")
	public List<Seasons> listAllSeason() {
		return seasonService.listAllSeasons();
	}
	
	/*@GetMapping("/listAllSeasonId/{tvShowId}")
	public List<Seasons> listSeasonsById(@PathVariable Long tvShowId) {
		return seasonService.findBySeasonId(tvShowId);
	}*/
	

}
