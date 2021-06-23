/*
 * TvShows's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.response.NetflixResponse;
import com.netflix.restModel.TvShowsRestModel;
import com.netflix.service.CategoriesServiceI;
import com.netflix.service.TvShowsServiceI;
import com.netflix.utils.constants.CommonConstants;
import com.netflix.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

// TODO: Auto-generated Javadoc
/**
 * The Class TvShowsController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_TV_SHOW)
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
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos las series por el Id de la categoria"
            ,notes = "Este end point sirve para obtener una lista de las series pasandole como parámetro el category-id")
	
	@GetMapping("/categories/{categoryId}")
	public NetflixResponse<List<TvShowsRestModel>> listTvShowsByCategoryId(@PathVariable Long categoryId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,tvShowsService.findByCategoryId(categoryId));
	}
	
	/**
	 * List tv shows by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos las series por el tvShow-id de la serie"
            ,notes = "Este end point sirve para obtener las series, le pasamos el parámetro del tvShow-id")
	
	@GetMapping("/{tvShow-id}")
	public NetflixResponse<TvShowsRestModel> listTvShowById(@PathVariable(value="tvShow-id") Long tvShowId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,tvShowsService.findById(tvShowId));
	}
	
	/**
	 * Adds the categories to tv show.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Añadimos una categoria nueva a una serie"
            ,notes = "Este end point sirve añadir una categoria nueva a una serie, para ello debemos pasarle "
            		+ "los parametros de listCategories y tvShowId")
	
	@PostMapping("/{tvShow-id}/categories")
	public ResponseEntity<String> addCategoriesToTvShow(@PathVariable(value="tvShow-id") Long tvShowId, @RequestParam Set<Long> listCategories) throws NetflixException {
		return ResponseEntity.status(HttpStatus.OK).body("La categoria se ha insertado correctamente");
	}
	
	/**
	 * Update tv show name.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el nombre de una serie"
			, notes = "Este end point sirve para actualizar el nombre de una serie por su Id")
	
	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public NetflixResponse<TvShowsRestModel> updateTvShowName(@PathVariable Long tvShowId, @PathVariable String tvShowName) throws NetflixException  {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowsService.updateTvShowName(tvShowId, tvShowName));
	}	
	
	/**
	 * Delete tv show by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Eliminamos una serie", 
			notes = "Este end point sirve para eliminar una serie, para ello debemos pasarle como parámetro su tvShowId")
	
	@DeleteMapping(value = RestConstants.RESOURCE_ID)
	public NetflixResponse<String> deleteTvShowById(@PathVariable(value="id") Long tvShowId) throws NetflixException {
		tvShowsService.deleteByTvShowId(tvShowId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}
}
