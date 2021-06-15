package com.netflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.model.Categories;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;

@Repository
@Qualifier("SeasonsRepository")
public interface SeasonsRepository  extends JpaRepository<Seasons, Long>{
	
	public List<Seasons> findSeasonByTvShows(TvShows tvShowId);
}
