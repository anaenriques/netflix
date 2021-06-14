package com.netflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.model.Categories;
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;

@Repository
@Qualifier("TvShowsRepository")
public interface TvShowsRepository  extends JpaRepository<TvShows, Integer>{
	
	public List<TvShows> findByCategoryId(Categories categoryId);

	public static List<Seasons> findBySeasonId(Seasons seasons) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
