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

import com.netflix.model.Categories;
import com.netflix.model.Chapters;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.service.CategoriesServiceI;
import com.netflix.service.ChaptersServiceI;


// TODO: Auto-generated Javadoc
/**
 * The Class ChapterController.
 */
@RestController
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
	 */
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}/chapters")
	public List<Chapters> listTvShowsAndNumber(@PathVariable long seriesId, @PathVariable int seasonNumber) {
		return chapterService.findByTvShowsAndNumber(seriesId,seasonNumber);
	}
	
	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param seriesId the series id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 */
	@GetMapping("/series/{seriesId}/seasons/{seasonNumber}/chapters/{chapterNumber}")
	public Chapters listTvShowsAndNumberAndChapterNumber(@PathVariable long seriesId, @PathVariable int seasonNumber, @PathVariable int chapterNumber) {
		return chapterService.findByTvShowsAndNumberAndChapterNumber(seriesId,seasonNumber,chapterNumber);
	}

}
