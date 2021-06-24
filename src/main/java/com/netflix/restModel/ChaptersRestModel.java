/*
 * Chapters RestModel
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
 * The Class ChaptersRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * Gets the duration.
 *
 * @return the duration
 */

/**
 * Gets the duration.
 *
 * @return the duration
 */
@Getter

/**
 * Sets the duration.
 *
 * @param duration the new duration
 */

/**
 * Sets the duration.
 *
 * @param duration the new duration
 */
@Setter

/**
 * Instantiates a new chapters rest model.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 * @param duration the duration
 */
@AllArgsConstructor

/**
 * Instantiates a new chapters rest model.
 */
@NoArgsConstructor
public class ChaptersRestModel implements Serializable{
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="id")
	private Long id;
	
	/** The number. */
	@JsonProperty(value="number")
	private int number;
	
	/** The name. */
	@JsonProperty(value="name")
	private String name;
	
	/** The duration. */
	@JsonProperty(value="duration")
	private int duration;
}
