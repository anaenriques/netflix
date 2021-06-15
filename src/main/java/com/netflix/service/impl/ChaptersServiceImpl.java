package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.model.Chapters;
import com.netflix.repository.ChaptersRepository;
import com.netflix.service.ChaptersServiceI;


	@Service
	@Qualifier("ChaptersServiceImpl")
	public class ChaptersServiceImpl implements ChaptersServiceI{
	 
	@Autowired
	@Qualifier("ChaptersRepository")
	private ChaptersRepository chaptersRepository;
	

	@Override
	public List<Chapters> findByTvShowsAndNumber(long tvshowId, int seasonNumber) {
		return chaptersRepository.listTvShowsAndNumber(tvshowId,seasonNumber);
	}
	
	@Override
	public Chapters findByTvShowsAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber) {
		return chaptersRepository.findChaptersByTvShowsAndNumberAndChapterNumber(tvshowId,seasonNumber,chapterNumber);
	}
	


}
