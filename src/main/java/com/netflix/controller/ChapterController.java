/*
 * Chapter's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.model.Categories;
import com.netflix.model.Chapters;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.restModel.ChaptersRestModel;
import com.netflix.service.CategoriesServiceI;
import com.netflix.service.ChaptersServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;


// TODO: Auto-generated Javadoc
/**
 * The Class ChapterController.
 */
@RestController
@SwaggerDefinition
public class ChapterController {
	
	/** The chapter service. */
	@Autowired
	@Qualifier("ChaptersServiceImpl")
	
	private ChaptersServiceI chapterService;
		
	/**
	 * List tv shows and number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos todos los capítulos y temporadas de una serie"
            ,notes = "Este end point sirve para listar todos los capitulos y temporadas de una serie en concreto, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping("/tvShows/{tvShowId}/seasons/{seasonNumber}/chapters")
	public List<ChaptersRestModel> listTvShowsAndNumber(@PathVariable long tvShowId, @PathVariable(value="seasonNumber") int seasonNumber) throws NetflixException {
		return chapterService.findByTvShowsAndNumber(tvShowId,seasonNumber);
	}
	
	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 * @throws NetflixException 
	 */
	@ApiOperation(value = "Listamos el capítulo y temporada de una serie"
            ,notes = "Este end point sirve para listar el capítulo y temporada de una serie, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie, el season-number de las temporada y"
            		+ "el chapter-number de un capítulo")
	
	@GetMapping("/tvShows/{tvShowId}/seasons/{seasonNumber}/chapters/{chapterNumber}")
	public ChaptersRestModel listTvShowsAndNumberAndChapterNumber(@PathVariable long tvShowId, 
			@PathVariable int seasonNumber, @PathVariable int chapterNumber) throws NetflixException {
		return chapterService.findByTvShowsAndNumberAndChapterNumber(tvShowId,seasonNumber,chapterNumber);
	}

}
