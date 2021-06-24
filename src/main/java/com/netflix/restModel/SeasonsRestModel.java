/*
 * Seasons RestModel
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
 * The Class SeasonsRestModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * Gets the name.
 *
 * @return the name
 */
@Getter

/**
 * Sets the name.
 *
 * @param name the new name
 */
@Setter 

/**
 * Instantiates a new seasons rest model.
 *
 * @param id the id
 * @param number the number
 * @param name the name
 */
@AllArgsConstructor

/**
 * Instantiates a new seasons rest model.
 */
@NoArgsConstructor
public class SeasonsRestModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="ID")
	private Long id;
	
	/** The number. */
	@JsonProperty(value="NUMBER")
	private int number;
	
	/** The name. */
	@JsonProperty(value="NAME")
	private String name;
	
	
	
}
