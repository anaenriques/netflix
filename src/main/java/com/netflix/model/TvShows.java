/*
 * TvShows's Entity
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.model.TvShows;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class TvShows.
 */
@Entity
@Table(name= "TV_SHOWS")

/**
 * Gets the advertising.
 *
 * @return the advertising
 */
@Getter

/**
 * Sets the advertising.
 *
 * @param advertising the new advertising
 */
@Setter

/**
 * Instantiates a new tv shows.
 */
@NoArgsConstructor

/**
 * Instantiates a new tv shows.
 *
 * @param id the id
 * @param name the name
 * @param shortDescription the short description
 * @param longDescription the long description
 * @param year the year
 * @param recommendedAge the recommended age
 * @param categoryId the category id
 * @param seasons the seasons
 * @param advertising the advertising
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class TvShows implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	@ApiModelProperty(position = 0)
	private Long id;
	
	/** The name. */
	@Column(name = "NAME")
	private String name;
	
	/** The short description. */
	@Column(name = "SHORT_DESC")
	private String shortDescription;
	
	/** The long description. */
	@Column(name = "LONG_DESC")
	private String longDescription;
	
	/** The year. */
	@Column(name = "YEAR")
	private int year;
	
	/** The recommended age. */
	@Column(name = "RECOMMENDED_AGE")
	private int recommendedAge;
	
	/** The category id. */
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="categoryId", referencedColumnName="ID")
	@JsonIgnore
	private Categories categoryId;
	
	/** The seasons. */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShows")
	private List<Seasons> seasons;
	
	/** The advertising. */
	@Column(name = "ADVERTISING")
	private String advertising;
	
	@JoinTable(name = "CATEGORY_TVSHOWS",
		    joinColumns = @JoinColumn(name = "TVSHOW_ID", nullable = false),
		    inverseJoinColumns = @JoinColumn(name="CATEGORY_ID", nullable = false)
		)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Categories> categories;
}
