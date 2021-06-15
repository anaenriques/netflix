package com.netflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.netflix.repository.ChaptersRepository;
import com.netflix.repository.SeasonsRepository;
import com.netflix.repository.TvShowsRepository;
import com.netflix.service.ChaptersServiceI;


	@Service
	@Qualifier("ChaptersServiceImpl")
	public class ChaptersServiceImpl implements ChaptersServiceI{
	 
	@Autowired
	@Qualifier("ChaptersRepository")
	private ChaptersRepository chaptersRepository;
	
	@Autowired
	@Qualifier("SeasonsRepository")
	private SeasonsRepository seasonsRepository;
	
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;


	


}
