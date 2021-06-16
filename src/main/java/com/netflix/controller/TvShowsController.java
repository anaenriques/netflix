/*
 * TvShows's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.model.Categories;
import com.netflix.model.TvShows;
import com.netflix.service.TvShowsServiceI;
import com.netflix.service.CategoriesServiceI;

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
	
	/** The categories service. */
	@Autowired
	@Qualifier("CategoriesServiceImpl")
	
	private CategoriesServiceI categoriesService;
	
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
	
	/**
	 * Adds the categories to tv show.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the response entity
	 */
	@PostMapping("/tvShows/addCategories/{tvShowId}/")
	public ResponseEntity<String> addCategoriesToTvShow(@PathVariable Long tvShowId, @RequestParam Set<Long> listCategories) {
		Set<Categories> categories = categoriesService.listCategoriesByIds(listCategories);
		TvShows tvShow = tvShowsService.findById(tvShowId);
		tvShow.getCategories().addAll(categories);
		tvShowsService.updateTvShows(tvShow);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha insertado la categoria correctamente");
	}
}
