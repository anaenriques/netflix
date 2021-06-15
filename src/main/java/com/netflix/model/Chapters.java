package com.netflix.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.model.Chapters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "CHAPTERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Chapters implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;
	
	@Column(name = "NUMBER")
	private int number;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DURATION")
	private int duration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "season_Id", referencedColumnName = "ID")
	@JsonIgnore
	private Seasons seasons;

}
