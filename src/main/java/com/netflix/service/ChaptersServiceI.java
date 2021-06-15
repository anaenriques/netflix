package com.netflix.service;

import java.util.List;

import com.netflix.model.Chapters;



public interface ChaptersServiceI {
	
	List<Chapters> findByTvShowsAndNumber(long tvshowId,int seasonNumber);
	Chapters findByTvShowsAndNumberAndChapterNumber(long tvshowId, int seasonNumber, int chapterNumber);
}
