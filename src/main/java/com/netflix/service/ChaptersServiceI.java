package com.netflix.service;

import java.util.List;

import com.netflix.model.Categories;
import com.netflix.model.Chapters;
import com.netflix.model.TvShows;

public interface ChaptersServiceI {
	
	List<Chapters> listAllChpaters();
}
