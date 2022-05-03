package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *  Entity Per La Tabella Effettiva Relazione Gioco Utente
 */
@Entity
@Table(name = "RatingGiochi")
@Data
@Getter
@Setter
@Builder
@ToString
public class GiocoRating {
	
	@EmbeddedId
	GiocoRatingKey IDGiocoRating;
	
	@ManyToOne
	@MapsId("IDUtente")
	@JoinColumn(name = "IDUtente")
	Utente utente;
	
	@ManyToOne
	@MapsId("IDGioco")
	@JoinColumn(name = "IDGioco")
	Gioco gioco;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "reviewText")
	private String reviewText;
}
