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
	@GetMapping("/tvShows/{serie-id}/seasons/{season-number}/chapters/{chapter-number}")
	public Chapters listTvShowsAndNumberAndChapterNumber(@PathVariable(value="serie-id") long seriesId, 
			@PathVariable(value="season-number") int seasonNumber, @PathVariable(value="chapter-number") int chapterNumber) throws NetflixException {
		return chapterService.findByTvShowsAndNumberAndChapterNumber(seriesId,seasonNumber,chapterNumber);
	}

}
