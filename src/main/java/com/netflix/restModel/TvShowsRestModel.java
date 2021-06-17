/*
 * TvShows RestModel
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.restModel;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.model.Categories;

import lombok.Getter;
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

/**
 * Sets the name.
 *
 * @param name the new name
 */
@Setter 
public class TvShowsRestModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@JsonProperty(value="ID")
	private Long id;
	
	/** The name. */
	@JsonProperty(value="NAME")
	private String name;
	
	@JsonProperty(value="SHORT_DESC")
	private String shortDescription;
	
	@JsonProperty(value="LONG_DESC")
	private String longDescription;
	
	@JsonProperty(value="YEAR")
	@JsonFormat(pattern="yyyy")
	private Date year;
	
	@JsonProperty(value="RECOMMENDED_AGE")
	private int recommendedAge;
	
	@JsonProperty(value="categoryId")
	private Categories categoryId;
	
	@JsonProperty(value="ADVERTISING")
	private String advertising;
	
}
