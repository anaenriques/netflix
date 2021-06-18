/*
 * Categories's Entity
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.model.Categories;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Categories.
 */
@Entity
@Table(name= "CATEGORIES")

/**
 * Gets the tv show.
 *
 * @return the tv show
 */
@Getter

/**
 * Sets the tv show.
 *
 * @param tvShow the new tv show
 */
@Setter

/**
 * Instantiates a new categories.
 */
@NoArgsConstructor

/**
 * Instantiates a new categories.
 *
 * @param id the id
 * @param name the name
 * @param tvShow the tv show
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class Categories implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;
	
	/** The name. */
	@Column(name = "NAME")
	private String name;
	
//	/** The tv show. */
//	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoryId")
//	private List<TvShows> tvShow;
	
	
	/** The tv shows. */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="categories")
	private List<TvShows> tvShows;
	

}
