/*
 * Seasons's ServiceImpl
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
import com.netflix.model.Seasons;
import com.netflix.model.TvShows;
import com.netflix.repository.SeasonsRepository;
import com.netflix.restModel.SeasonsRestModel;
import com.netflix.service.SeasonsServiceI;
import com.netflix.utils.constants.ExceptionConstants;


	// TODO: Auto-generated Javadoc
/**
	 * The Class SeasonsServiceImpl.
	 */
	@Service
	@Qualifier("SeasonsServiceImpl")
    public class SeasonsServiceImpl implements SeasonsServiceI{
	 
	/** The seasons repository. */
	@Autowired
	@Qualifier("SeasonsRepository")
	private SeasonsRepository seasonsRepository;
	
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * List all seasons.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<SeasonsRestModel> listAllSeasons() throws NetflixException{
		
		List<Seasons> seasons=seasonsRepository.findAll();
		
		if (seasons.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON);
		}
		return seasons.stream().map(season -> modelMapper.map(season, SeasonsRestModel.class)).collect(Collectors.toList());
	}
	
	/**
	 * Find by id.
	 *
	 * @param tvShowId the tv show id
	 * @return the seasons
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public SeasonsRestModel findById (Long tvShowId) throws NetflixException{
		
		Seasons seasons = seasonsRepository.findById(tvShowId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON) );
		return modelMapper.map(seasons, SeasonsRestModel.class);
	}

	
	/**
	 * Find by tv shows.
	 *
	 * @param tvshows the tvshows
	 * @return the list
	 * @throws NotFoundException the not found exception
	 */
	@Override
	public List<SeasonsRestModel> findByTvShows(TvShows tvshows) throws NotFoundException {
		
		List<Seasons> seasons=seasonsRepository.findByTvShows(tvshows);
		
		if (seasons.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON);
		}
		return seasons.stream().map(season -> modelMapper.map(season, SeasonsRestModel.class)).collect(Collectors.toList());
	}
	
	
	/**
	 * Find by tv shows id and number.
	 *
	 * @param tvShowId the tv show id
	 * @param seasonNumber the season number
	 * @return the seasons rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public SeasonsRestModel findByTvShowsIdAndNumber(Long tvShowId, int seasonNumber) throws NetflixException {
		
		Seasons seasons = seasonsRepository.findByTvShowsIdAndNumber(tvShowId,seasonNumber);
		return modelMapper.map(seasons, SeasonsRestModel.class);
		
	}
	
	
	
}
