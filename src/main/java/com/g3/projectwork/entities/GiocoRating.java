package com.g3.projectwork.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/*
 *  Entity Per La Tabella Effettiva Relazione Gioco Utente
 */
@Entity
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
	
	private double rating;
	
	private String reviewText;
	
	public GiocoRating() {
	}

	public GiocoRating(GiocoRatingKey iDGiocoRating, Utente utente, Gioco gioco, double rating, String reviewText) {
		super();
		IDGiocoRating = iDGiocoRating;
		this.utente = utente;
		this.gioco = gioco;
		this.rating = rating;
		this.reviewText = reviewText;
	}

	public GiocoRatingKey getIDGiocoRating() {
		return IDGiocoRating;
	}

	public void setIDGiocoRating(GiocoRatingKey iDGiocoRating) {
		IDGiocoRating = iDGiocoRating;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Gioco getGioco() {
		return gioco;
	}

	public void setGioco(Gioco gioco) {
		this.gioco = gioco;
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

	@Override
	public String toString() {
		return "GiocoRating [IDGiocoRating=" + IDGiocoRating + ", utente=" + utente + ", gioco=" + gioco + ", rating="
				+ rating + ", reviewText=" + reviewText + "]";
	}

}
