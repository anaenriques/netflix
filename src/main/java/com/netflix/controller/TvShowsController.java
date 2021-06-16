/*
 * TvShows's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.TvShows;
import com.netflix.service.TvShowsServiceI;

// TODO: Auto-generated Javadoc
/**
 * The Class TvShowsController.
 */
@RestController
public class TvShowsController {
	
	/** The tv shows service. */
	@Autowired
	@Qualifier("TvShowsServiceImpl")
	
	private TvShowsServiceI tvShowsService;
	
	/**
	 * List tv shows by name.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	@GetMapping("/categories/{categoryId}")
	public List<TvShows> listTvShowsByName(@PathVariable Long categoryId) {
		return tvShowsService.findByCategoryId(categoryId);
	}
	
	/**
	 * List tv shows by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 */
	@GetMapping("/tvShow/{tvShowId}")
	public TvShows listTvShowsById(@PathVariable Long tvShowId) {
		return tvShowsService.findById(tvShowId);
	}
	
}
