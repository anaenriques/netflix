/*
 * Chapters's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

import com.netflix.exception.NetflixException;
import com.netflix.restModel.ChaptersRestModel;



// TODO: Auto-generated Javadoc
/**
 * The Interface ChaptersServiceI.
 */
public interface ChaptersServiceI {
	
	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ChaptersRestModel> findByTvShowsAndNumber(long tvshowId,int seasonNumber)throws NetflixException;
	
	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 * @throws NetflixException the netflix exception
	 */
	ChaptersRestModel findByTvShowsAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) throws NetflixException;

	/**
	 * Update chapter name.
	 *
	 * @param chapterId the chapter id
	 * @param chapterName the chapter name
	 * @return the chapters rest model
	 * @throws NetflixException the netflix exception
	 */
	ChaptersRestModel updateChapterName(Long chapterId, String chapterName) throws NetflixException;
}
