/*
 * Actors's Service
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.service;

import java.util.List;

import com.netflix.exception.NetflixException;
import com.netflix.restModel.ActorsRestModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoriesServiceI.
 */
public interface ActorsServiceI {
	
	
	/**
	 * List all actors.
	 *
	 * @return the list
	 * @throws NetflixException the netflix exception
	 */
	List<ActorsRestModel> listAllActors() throws NetflixException;
	
	/**
	 * Find by id.
	 *
	 * @param actorId the actor id
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorsRestModel findById(Long actorId)throws NetflixException;

	/**
	 * Adds the actor.
	 *
	 * @param actor the actor
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */
	ActorsRestModel addActor(ActorsRestModel actor) throws NetflixException;

	/**
	 * Update actor.
	 *
	 * @param actor the actor
	 * @param actorId the actor id
	 * @return the actors rest model
	 * @throws NetflixException the netflix exception
	 */

	ActorsRestModel updateActor(ActorsRestModel actor, Long actorId) throws NetflixException;

	/**
	 * Delete by actor id.
	 *
	 * @param actorId the actor id
	 * @throws NetflixException the netflix exception
	 */
	void deleteByActorId(Long actorId)throws NetflixException;
}
