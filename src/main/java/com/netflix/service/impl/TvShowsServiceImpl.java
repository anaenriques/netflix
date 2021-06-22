/*
 * TvShows's ServiceImpl
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
	 * @throws NetflixException 
	 */
	@Override
	public List<TvShowsRestModel> findByCategoryId(Long categoryId) throws NetflixException {
		return tvShowsRepository.findByCategoriesId(categoryId).stream().map(tvShows -> modelMapper.map(tvShows, TvShowsRestModel.class)).collect(Collectors.toList());
	}

	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the tv shows
	 * @throws Exception 
	 */
	@Override
	public TvShowsRestModel findById(Long tvShowId) throws NetflixException {
		TvShows tvShows = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW) );
		return modelMapper.map(tvShows, TvShowsRestModel.class);
	}

	@Override
	public TvShowsRestModel updateTvShows(Long tvShowId) throws NetflixException{
		TvShows tvShows = tvShowsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TVSHOW) );
		tvShowsRepository.save(tvShows);
		return modelMapper.map(tvShows, TvShowsRestModel.class);
	}

}
