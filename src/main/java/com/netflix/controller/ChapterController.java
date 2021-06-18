/*
 * Chapter's Controller
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
import com.netflix.model.Categories;
import com.netflix.model.Chapters;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
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
	
	@GetMapping("/tvShows/{tvShow-id}/seasons/{season-number}/chapters")
	public List<Chapters> listTvShowsAndNumber(@PathVariable(value="tvShow-id") long seriesId, @PathVariable(value="season-number") int seasonNumber) throws NetflixException {
		return chapterService.findByTvShowsAndNumber(seriesId,seasonNumber);
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
	
	@GetMapping("/tvShows/{serie-id}/seasons/{season-number}/chapters/{chapter-number}")
	public Chapters listTvShowsAndNumberAndChapterNumber(@PathVariable(value="serie-id") long seriesId, 
			@PathVariable(value="season-number") int seasonNumber, @PathVariable(value="chapter-number") int chapterNumber) throws NetflixException {
		return chapterService.findByTvShowsAndNumberAndChapterNumber(seriesId,seasonNumber,chapterNumber);
	}

}
