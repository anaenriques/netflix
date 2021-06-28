/*
 * Actors Controller
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.exception.NetflixException;
import com.netflix.response.NetflixResponse;
import com.netflix.restModel.ActorsRestModel;
import com.netflix.service.ActorsServiceI;
import com.netflix.utils.constants.CommonConstants;
import com.netflix.utils.constants.RestConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;



// TODO: Auto-generated Javadoc
/**
 * The Class ActorsController.
 */
@RestController
@SwaggerDefinition
@RequestMapping(RestConstants.RESOURCE_ACTOR)
public class ActorsController {
	
	
	/** The actors service. */
	@Autowired
	@Qualifier("ActorsServiceImpl")
	
	private ActorsServiceI actorsService;
	
	
	/**
	 * List all actors.
	 *
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos el total de los actores"
            ,notes = "Este end point sirve para listar todos los actores")
	
	@GetMapping
	public NetflixResponse<List<ActorsRestModel>> listAllActors() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,actorsService.listAllActors());
	}
	
	/**
	 * List actor by id.
	 *
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Listamos la ficha de un actor"
            ,notes = "Este end point sirve para obtener la ficha de un actor concreto, le pasamos el parámetro del actor-id")
	
	@GetMapping("/{actor-id}")
	public NetflixResponse<ActorsRestModel> listActorById(@PathVariable(value="actor-id") Long actorId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),CommonConstants.OK,actorsService.findById(actorId));
	}
	
	
	/**
	 * Adds the categories to tv show.
	 *
	 * @param actor the actor
	 * @return the response entity
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Añadimos un actor nuevo"
            ,notes = "Este end point sirve añadir un nuevo actor para ello le pasamos "
            		+ "los parametros de actorId, name y age")
	
	@PostMapping
	public NetflixResponse<ActorsRestModel> addActor(@RequestBody ActorsRestModel actor) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED),CommonConstants.SUCCESS, actorsService.addActor(actor));
	}
	
	/**
	 * Update actor.
	 *
	 * @param actor the actor
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Actualizamos los datos de un actor"
			, notes = "Este end point sirve para actualizar los datos de un actor por su Id")
	
	@PatchMapping(value = RestConstants.RESOURCE_ACTOR_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public NetflixResponse<ActorsRestModel> updateActor(@RequestBody ActorsRestModel actor, Long actorId) throws NetflixException  {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorsService.updateActor(actor, actorId));
	}	
	
	/**
	 * Delete actor by id.
	 *
	 * @param actorId the actor id
	 * @return the netflix response
	 * @throws NetflixException the netflix exception
	 */
	@ApiOperation(value = "Eliminamos un actor", 
			notes = "Este end point sirve para eliminar un actor, para ello debemos pasarle como parámetro su actorId")
	
	@DeleteMapping(value = RestConstants.RESOURCE_ID)
	public NetflixResponse<String> deleteActorById(@PathVariable(value="id") Long actorId) throws NetflixException {
		actorsService.deleteByActorId(actorId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}
	
	
}
