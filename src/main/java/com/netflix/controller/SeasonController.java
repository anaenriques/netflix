/*
 * Season's Controller
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

import com.netflix.exception.NetflixException;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.service.SeasonsServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;


// TODO: Auto-generated Javadoc
/**
 * The Class SeasonController.
 */
@RestController
@SwaggerDefinition
public class SeasonController {
	
	/** The season service. */
	@Autowired
	@Qualifier("SeasonsServiceImpl")
	private SeasonsServiceI seasonService;
	
	
	/**
	 * List seasons by id.
	 *
	 * @param seriesId the series id
	 * @return the list
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos los capitulos de una serie"
            ,notes = "Este end point sirve para listar todos los capitulos de una serie, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie")
	
	@GetMapping("/tvShows/{tvShow-id}/seasons")
	public List<Seasons> listSeasonsById(@PathVariable(value="tvShow-id") Long seriesId) throws NetflixException {
		final TvShows tvShows = new TvShows();
		tvShows.setId(seriesId);
		return seasonService.findByTvShows(tvShows);
	}
	
	/**
	 * List tv shows and number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos el número de temporadas de una serie en concreto"
            ,notes = "Este end point sirve para listar el número de temporadas de una serie, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping("/tvShows/{tvShow-id}/seasons/{season-number}")
	public List<Seasons> listTvShowsAndNumber(@PathVariable(value="tvShow-id") Long seriesId, 
			@PathVariable(value="season-number") int seasonNumber) throws NetflixException {
		final TvShows tvShows = new TvShows();
		tvShows.setId(seriesId);
		return seasonService.findByTvShowsAndNumber(tvShows,seasonNumber);
	}
	

	

}
