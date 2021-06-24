/*
 * TvShows's Repository
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.model.TvShows;

// TODO: Auto-generated Javadoc
/**
 * The Interface TvShowsRepository.
 */
@Repository
@Qualifier("TvShowsRepository")
public interface TvShowsRepository  extends JpaRepository<TvShows, Long>{
	
	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 */
	public List<TvShows> findByCategoriesId(Long categoryId);

	
}
