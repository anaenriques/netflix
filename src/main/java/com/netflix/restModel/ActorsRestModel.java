/*
 * Actors RestModel
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.restModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// TODO: Auto-generated Javadoc

/**
 * The Class CategoriesRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * Gets the name.
 *
 * @return the name
 */

/**
 * Gets the actor id.
 *
 * @return the actor id
 */
@Getter

/**
 * Sets the name.
 *
 * @param name the new name
 */

/**
 * Sets the actor id.
 *
 * @param actorId the new actor id
 */
@Setter

/**
 * Instantiates a new categories rest model.
 *
 * @param id the id
 * @param name the name
 */

/**
 * Instantiates a new actors rest model.
 *
 * @param name the name
 * @param age the age
 * @param actorId the actor id
 */
@AllArgsConstructor

/**
 * Instantiates a new categories rest model.
 */

/**
 * Instantiates a new actors rest model.
 */
@NoArgsConstructor

public class ActorsRestModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	
	/** The name. */
	@JsonProperty(value="name")
	private String name;
	
	/** The age. */
	@JsonProperty(value="age")
	private int age;
	
	/** The actor id. */
	@JsonProperty(value="actorId")
	private int actorId;
	
}
