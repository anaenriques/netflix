/*
 * Chapters's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Chapters;
import com.netflix.repository.ChaptersRepository;
import com.netflix.service.ChaptersServiceI;


	// TODO: Auto-generated Javadoc
/**
	 * The Class ChaptersServiceImpl.
	 */
	@Service
	@Qualifier("ChaptersServiceImpl")
	public class ChaptersServiceImpl implements ChaptersServiceI{
	 
	/** The chapters repository. */
	@Autowired
	@Qualifier("ChaptersRepository")
	private ChaptersRepository chaptersRepository;
	

	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 */
	@Override
	public List<Chapters> findByTvShowsAndNumber(long tvshowId, int seasonNumber) {
		return chaptersRepository.listTvShowsAndNumber(tvshowId,seasonNumber);
	}
	
	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 */
	@Override
	public Chapters findByTvShowsAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) {
		return chaptersRepository.findChaptersByTvShowsAndNumberAndChapterNumber(tvshowId,seasonNumber,chapterNumber);
	}
	


}
