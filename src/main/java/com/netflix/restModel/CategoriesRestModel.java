/*
 * Categories RestModel
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
@Getter

/**
 * Sets the name.
 *
 * @param name the new name
 */
@Setter

/**
 * Instantiates a new categories rest model.
 *
 * @param id the id
 * @param name the name
 */
@AllArgsConstructor

/**
 * Instantiates a new categories rest model.
 */
@NoArgsConstructor

public class CategoriesRestModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="id")
	private Long id;
	
	/** The name. */
	@JsonProperty(value="name")
	private String name;
	
}
