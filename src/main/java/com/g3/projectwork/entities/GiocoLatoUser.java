package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "GiocoLatoUser")
public class GiocoLatoUser {
	
	@Id
	@SequenceGenerator(
			name= "giocoLatoUser_sequence",
			sequenceName = "giocoLatoUser_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "giocoLatoUser_sequence")
	private Long IDGiocoLatoUtente;
	
	@Column(name = "rating")
	@Min(value = 1)
	@Max(value = 5)
	private double rating;
	
	@Column(name = "reviewtext")
	private String reviewText;
	
	@Column(name = "oreDiGioco")
	@Min(value = 0)
	private double oreDiGioco;
	
	@Column(name = "IDLista")
	@NotBlank(message = "IDLista necessario")
	private Long IDLista;
	@Column(name = "IDUtente")
	@NotBlank(message = "IDUtente necessario")
	private Long IDUtente;
	@Column(name = "IDGioco")
	@NotBlank(message = "IDGioco necessario")
	private Long IDGioco;
	
	public GiocoLatoUser() {
		
	}

	public GiocoLatoUser(Long iDGiocoLatoUtente, @Min(1) @Max(5) double rating, String reviewText,
			@Min(0) double oreDiGioco, @NotBlank(message = "IDLista necessario") Long iDLista,
			@NotBlank(message = "IDUtente necessario") Long iDUtente,
			@NotBlank(message = "IDGioco necessario") Long iDGioco) {
		super();
		IDGiocoLatoUtente = iDGiocoLatoUtente;
		this.rating = rating;
		this.reviewText = reviewText;
		this.oreDiGioco = oreDiGioco;
		IDLista = iDLista;
		IDUtente = iDUtente;
		IDGioco = iDGioco;
	}

	public GiocoLatoUser(@Min(1) @Max(5) double rating, String reviewText, @Min(0) double oreDiGioco,
			@NotBlank(message = "IDLista necessario") Long iDLista,
			@NotBlank(message = "IDUtente necessario") Long iDUtente,
			@NotBlank(message = "IDGioco necessario") Long iDGioco) {
		super();
		this.rating = rating;
		this.reviewText = reviewText;
		this.oreDiGioco = oreDiGioco;
		IDLista = iDLista;
		IDUtente = iDUtente;
		IDGioco = iDGioco;
	}

	public Long getIDGiocoLatoUtente() {
		return IDGiocoLatoUtente;
	}

	public void setIDGiocoLatoUtente(Long iDGiocoLatoUtente) {
		IDGiocoLatoUtente = iDGiocoLatoUtente;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public double getOreDiGioco() {
		return oreDiGioco;
	}

	public void setOreDiGioco(double oreDiGioco) {
		this.oreDiGioco = oreDiGioco;
	}

	public Long getIDLista() {
		return IDLista;
	}

	public void setIDLista(Long iDLista) {
		IDLista = iDLista;
	}

	public Long getIDUtente() {
		return IDUtente;
	}

	public void setIDUtente(Long iDUtente) {
		IDUtente = iDUtente;
	}

	public Long getIDGioco() {
		return IDGioco;
	}

	public void setIDGioco(Long iDGioco) {
		IDGioco = iDGioco;
	}

	@Override
	public String toString() {
		return "GiocoLatoUser [IDGiocoLatoUtente=" + IDGiocoLatoUtente + ", rating=" + rating + ", reviewText="
				+ reviewText + ", oreDiGioco=" + oreDiGioco + ", IDLista=" + IDLista + ", IDUtente=" + IDUtente
				+ ", IDGioco=" + IDGioco + "]";
	}
	
	
}
