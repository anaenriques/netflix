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

import com.netflix.exception.NetflixException;
import com.netflix.model.Categories;
import com.netflix.model.TvShows;
import com.netflix.service.TvShowsServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

import com.netflix.service.CategoriesServiceI;

// TODO: Auto-generated Javadoc
/**
 * The Class TvShowsController.
 */
@RestController
@SwaggerDefinition
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
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos las series por el Id de la categoria"
            ,notes = "Este end point sirve para obtener una lista de las series pasandole como parámetro el category-id")
	
	@GetMapping("/categories/{category-id}")
	public List<TvShows> listTvShowsByName(@PathVariable (value="category-id") Long categoryId) throws NetflixException {
		return tvShowsService.findByCategoryId(categoryId);
	}
	
	/**
	 * List tv shows by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos las series por el tvShow-id de la serie"
            ,notes = "Este end point sirve para obtener las series, le pasamos el parámetro del tvShow-id")
	
	@GetMapping("/tvShows/{tvShow-id}")
	public TvShows listTvShowsById(@PathVariable(value="tvShow-id") Long tvShowId) throws NetflixException {
		return tvShowsService.findById(tvShowId);
	}
	
	/**
	 * Adds the categories to tv show.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the response entity
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Añadimos una categoria nueva a una serie"
            ,notes = "Este end point sirve añadir una categoria nueva a una serie, para ello debemos pasarle "
            		+ "los parametros de listCategories y tvShowId")
	
	@PostMapping("/tvShows/categories/{tvShow-id}/")
	public ResponseEntity<String> addCategoriesToTvShow(@PathVariable(value="tvShow-id") Long tvShowId, @RequestParam Set<Long> listCategories) throws NetflixException {
		Set<Categories> categories = categoriesService.listCategoriesByIds(listCategories);
		TvShows tvShow = tvShowsService.findById(tvShowId);
		tvShow.getCategories().addAll(categories);
		tvShowsService.updateTvShows(tvShow);
		return ResponseEntity.status(HttpStatus.OK).body("La categoria se ha insertado correctamente");
	}
}
