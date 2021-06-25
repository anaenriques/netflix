/*
 * Chapter's Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.response.NetflixResponse;
import com.netflix.restModel.ChaptersRestModel;
import com.netflix.service.ChaptersServiceI;
import com.netflix.utils.constants.CommonConstants;
import com.netflix.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;


// TODO: Auto-generated Javadoc
/**
 * The Class ChapterController.
 */
@RestController
@SwaggerDefinition
@RequestMapping
public class ChapterController {
	
	/** The chapter service. */
	@Autowired
	@Qualifier("ChaptersServiceImpl")
	
	private ChaptersServiceI chapterService;
		
	/**
	 * List tv shows and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos todos los capítulos y temporadas de una serie"
            ,notes = "Este end point sirve para listar todos los capitulos y temporadas de una serie en concreto, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie y el season-number de la temporada")
	
	@GetMapping(value = RestConstants.RESOURCE_CHAPTER)
	public NetflixResponse<List<ChaptersRestModel>> listTvShowsAndNumber(@PathVariable long tvShowId, @PathVariable(value="seasonNumber") int seasonNumber) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,chapterService.findByTvShowsAndNumber(tvShowId,seasonNumber));
	}
	
	/**
	 * List tv shows and number and chapter number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos el capítulo y temporada de una serie"
            ,notes = "Este end point sirve para listar el capítulo y temporada de una serie, para ello "
            		+ "le pasamos por parámetro el tvShow-id de la serie, el season-number de las temporada y"
            		+ "el chapter-number de un capítulo")
	
	@GetMapping(value = RestConstants.RESOURCE_CHAPTER+RestConstants.RESOURCE_NUMBER)
	public NetflixResponse<ChaptersRestModel> listTvShowsAndNumberAndChapterNumber(@PathVariable long tvShowId, 
			@PathVariable int seasonNumber, @PathVariable(value="number") int chapterNumber) throws NetflixException {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,chapterService.findByTvShowsAndNumberAndChapterNumber(tvShowId,seasonNumber,chapterNumber));
	}
	
	/**
	 * Update tv show name.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos el nombre de un capitulo"
			, notes = "Este end point sirve para actualizar el nombre de un capitulo por su Id")
	
	@PatchMapping(value = "/chapters"+ RestConstants.RESOURCE_CHAPTER_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ChaptersRestModel> updateChapterName(@PathVariable Long chapterId, @PathVariable String chapterName) throws NetflixException  {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				chapterService.updateChapterName(chapterId, chapterName));
	}	

}
