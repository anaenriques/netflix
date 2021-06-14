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
import com.netflix.model.Seasons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "SEASONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Seasons implements Serializable{
	
	private static final long serialVersionUID = 18080239613616000L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;
	
	@Column(name = "NUMBER")
	private int number;
	
	@Column(name = "NAME")
	private String name;
	
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="tvShowId", referencedColumnName="ID")
	private Seasons tvShowId;

}