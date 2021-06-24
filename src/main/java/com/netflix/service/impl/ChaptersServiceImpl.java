/*
 * Chapters's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.exception.NetflixException;
import com.netflix.exception.NotFoundException;
import com.netflix.model.Chapters;
import com.netflix.repository.ChaptersRepository;
import com.netflix.restModel.ChaptersRestModel;
import com.netflix.service.ChaptersServiceI;
import com.netflix.utils.constants.ExceptionConstants;


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
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * Find by tv shows and number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<ChaptersRestModel> findByTvShowsAndNumber(long tvshowId, int seasonNumber) throws NetflixException{
		
		List<Chapters> chapters=chaptersRepository.listTvShowsAndNumber(tvshowId,seasonNumber);
		if (chapters.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER);
		}
		return chapters.stream().map(chapter -> modelMapper.map(chapter, ChaptersRestModel.class)).collect(Collectors.toList());
	}
	
	/**
	 * Find by tv shows and number and chapter number.
	 *
	 * @param tvshowId the tvshow id
	 * @param seasonNumber the season number
	 * @param chapterNumber the chapter number
	 * @return the chapters
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ChaptersRestModel findByTvShowsAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) throws NetflixException{
		Chapters chapters = chaptersRepository.findChaptersByTvShowsAndNumberAndChapterNumber(tvshowId,seasonNumber, chapterNumber).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER) );
		return modelMapper.map(chapters, ChaptersRestModel.class);
	}
	
	/**
	 * Update chapter name.
	 *
	 * @param chapterId the chapter id
	 * @param chapterName the chapter name
	 * @return the chapters rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ChaptersRestModel updateChapterName(Long chapterId, String chapterName) throws NetflixException{
		
		Chapters chapters = chaptersRepository.findById(chapterId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER) );
		chapters.setName(chapterName);
		chaptersRepository.save(chapters);
		return modelMapper.map(chapters, ChaptersRestModel.class);
	}
	


}
