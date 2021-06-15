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


@RestController
public class ChapterController {
	
	@Autowired
	@Qualifier("ChaptersServiceImpl")
	
	private ChaptersServiceI chapterService;
	

}