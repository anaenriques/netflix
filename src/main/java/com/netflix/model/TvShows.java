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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.model.TvShows;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "TV_SHOWS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvShows implements Serializable{
	
	private static final long serialVersionUID = 18080239613616000L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SHORT_DESC")
	private String shortDescription;
	
	@Column(name = "LONG_DESC")
	private String longDescription;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "RECOMMENDED_AGE")
	private int recommendedAge;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="categoryId", referencedColumnName="ID")
	@JsonIgnore
	private Categories categoryId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShows")
	private List<Seasons> seasons;
	
	@Column(name = "ADVERTISING")
	private String advertising;
	
	
}
