/*
 * Actor's Entity
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Actors.
 */
@Entity
@Table(name= "ACTORS")

/**
 * Gets the tv shows.
 *
 * @return the tv shows
 */
@Getter

/**
 * Sets the tv shows.
 *
 * @param tvShows the new tv shows
 */
@Setter

/**
 * Instantiates a new actors.
 */
@NoArgsConstructor

/**
 * Instantiates a new actors.
 *
 * @param id the id
 * @param name the name
 * @param age the age
 * @param actorId the actor id
 * @param tvShows the tv shows
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class Actors implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 18080239613616000L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	@NonNull
	private Long id;
	
	/** The name. */
	@Column(name = "NAME")
	private String name;
	
	/** The age. */
	@Column(name = "AGE")
	private int age;
	
	/** The actor id. */
	@Column(name = "ACTOR_ID")
	private int actorId;
	
	/** The tv shows. */
	@JoinTable(name = "ACTORS_TVSHOWS",
		    joinColumns = @JoinColumn(name = "TVSHOW_ID", nullable = false),
		    inverseJoinColumns = @JoinColumn(name="ACTOR_ID", nullable = false)
		)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TvShows> tvShows;
}
