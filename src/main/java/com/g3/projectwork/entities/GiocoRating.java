package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "RatingGiochi")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiocoRating {
	
	@EmbeddedId
	@Builder.Default
	GiocoRatingKey IDGiocoRating = GiocoRatingKey.builder().build();
	
	@ManyToOne
	@MapsId("IDUtente")
	@Builder.Default
	Utente utente = null;
		
	@ManyToOne
	@MapsId("IDGioco")
	@Builder.Default
	Gioco gioco = null;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "reviewText")
	private String reviewText;
}
