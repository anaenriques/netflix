/*
 * Season's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.response.NetflixResponse;
import com.netflix.restModel.SeasonsRestModel;
import com.netflix.service.SeasonsServiceI;
import com.netflix.utils.constants.CommonConstants;
import com.netflix.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;


// TODO: Auto-generated Javadoc
/**
 * The Class SeasonController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_SEASON)
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
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos los capitulos de una serie"
            ,notes = "Este end point sirve para listar todos los capitulos de una serie, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie")
	
	@GetMapping
	public NetflixResponse<List<SeasonsRestModel>> listSeasonsById(@PathVariable(value="tvShowId") Long seriesId) throws NetflixException {
		final TvShows tvShows = new TvShows();
		tvShows.setId(seriesId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,seasonService.findByTvShows(tvShows));
	}
	
	/**
	 * List tv shows and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos el número de temporadas de una serie en concreto"
            ,notes = "Este end point sirve para listar el número de temporadas de una serie, para ello le pasamos como"
            		+ "parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping(value = RestConstants.RESOURCE_NUMBER)
	public NetflixResponse<SeasonsRestModel> listTvShowsAndNumber(@PathVariable Long tvShowId, 
			@PathVariable(value="number") int seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,seasonService.findByTvShowsIdAndNumber(tvShowId,seasonNumber));

	}
	

	

}
