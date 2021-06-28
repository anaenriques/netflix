/*
 * TvShows's ServiceImpl
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.exception.NetflixException;
import com.netflix.exception.NotFoundException;
import com.netflix.model.Categories;
import com.netflix.model.TvShows;
import com.netflix.repository.TvShowsRepository;
import com.netflix.restModel.TvShowsRestModel;
import com.netflix.service.CategoriesServiceI;
import com.netflix.service.TvShowsServiceI;
import com.netflix.utils.constants.ExceptionConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class TvShowsServiceImpl.
 */
@Service
@Qualifier("TvShowsServiceImpl")
public class TvShowsServiceImpl implements TvShowsServiceI {

	/** The tv shows repository. */
	@Autowired
	@Qualifier("TvShowsRepository")
	private TvShowsRepository tvShowsRepository;

	/** The categories repository. */
	@Autowired
	@Qualifier("CategoriesServiceImpl")
	private CategoriesServiceI categoriesService;
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Find by category id.
	 *
	 * @param categoryId the category id
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<TvShowsRestModel> findByCategoryId(Long categoryId) throws NetflixException {
		
		List<TvShows> tvShows=tvShowsRepository.findByCategoriesId(categoryId);
		if (tvShows.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW);
		}
		return tvShows.stream().map(tvShow -> modelMapper.map(tvShow, TvShowsRestModel.class)).collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowsRestModel findById(Long tvShowId) throws NetflixException {
		
		TvShows tvShows = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW) );
		return modelMapper.map(tvShows, TvShowsRestModel.class);
	}
	
	/**
	 * Adds the category.
	 *
	 * @param tvShowId the tv show id
	 * @param listCategories the list categories
	 * @return the tv shows rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowsRestModel addCategory(Long tvShowId,Set<Long> listCategories) throws NetflixException {
		
		Set<Categories> categories = categoriesService.listCategoriesByIds(listCategories);
		TvShows tvShow = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW) );
		tvShow.getCategories().addAll(categories);
		tvShowsRepository.save(tvShow);
		return modelMapper.map(tvShow, TvShowsRestModel.class);
	}

	
	/**
	 * Update tv shows.
	 *
	 * @param tvShowId the tv show id
	 * @param tvShowName the tv show name
	 * @return the tv shows rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public TvShowsRestModel updateTvShowName(Long tvShowId, String tvShowName) throws NetflixException{
		
		TvShows tvShows = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW) );
		tvShows.setName(tvShowName);
		tvShowsRepository.save(tvShows);
		return modelMapper.map(tvShows, TvShowsRestModel.class);
	}

	/**
	 * Delete by id.
	 *
	 * @param tvShowId the tv show id
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public void deleteByTvShowId(Long tvShowId) throws NetflixException {
		
		tvShowsRepository.deleteById(tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW)).getId());
	}
	
	/**
	 * List tv shows by ids.
	 *
	 * @param listTvShowsIds the list tv shows ids
	 * @return the sets the
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public Set<TvShows> listTvShowsByIds(Set<Long> listTvShowsIds) throws NetflixException {
		
		Set<TvShows> tvShows=new HashSet<>(tvShowsRepository.findAllById(listTvShowsIds));
		
		if (tvShows.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW);
		}
		return tvShows;
	}

}
