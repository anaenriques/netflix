/*
 * Actors's ServiceImpl
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
import com.netflix.model.Actors;
import com.netflix.repository.ActorsRepository;
import com.netflix.restModel.ActorsRestModel;
import com.netflix.service.ActorsServiceI;
import com.netflix.service.TvShowsServiceI;
import com.netflix.utils.constants.ExceptionConstants;

	// TODO: Auto-generated Javadoc
/**
	 * The Class ActorsServiceImpl.
	 */
	@Service
	@Qualifier("ActorsServiceImpl")
	public class ActorsServiceImpl implements ActorsServiceI{
	 
	/** The categories repository. */
	@Autowired
	@Qualifier("ActorsRepository")
	private ActorsRepository actorsRepository;
	
	/** The tv shows service. */
	@Autowired
	@Qualifier("TvShowsServiceImpl")
	private TvShowsServiceI tvShowsService;
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * List all actors.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public List<ActorsRestModel> listAllActors() throws NetflixException{

		List<Actors> actors= actorsRepository.findAll();
		
		if (actors.isEmpty()) {
			throw new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR);
		}
		return actors.stream().map(actor -> modelMapper.map(actor, ActorsRestModel.class)).collect(Collectors.toList());
	}


	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorsRestModel findById(Long actorId) throws NetflixException {
		
		Actors actors = actorsRepository.findById(actorId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR) );
		return modelMapper.map(actors, ActorsRestModel.class);
	}
	
	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorsRestModel addActor(ActorsRestModel actor) throws NetflixException {
		Actors newActor = modelMapper.map(actor, Actors.class);
		actorsRepository.save(newActor);
		return actor;
	}
	
	/**
	 * Update actor.
	 *
	 * @param actor the actor
	 * @param actorId the actor id
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public ActorsRestModel updateActor(ActorsRestModel actor, Long actorId) throws NetflixException{
		
		Actors newActor = actorsRepository.findById(actorId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR) );
		newActor.setName(actor.getName());
		newActor.setActorId(actor.getActorId());
		newActor.setAge(actor.getAge());
		actorsRepository.save(newActor);
		return actor;
	}


	/**
	 * Delete by actor id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	@Override
	public void deleteByActorId(Long actorId) throws NetflixException {
		
		actorsRepository.deleteById(actorsRepository.findById(actorId).orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR)).getId());
		
	}
	

}
