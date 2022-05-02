package com.g3.projectwork.model;

import java.time.LocalDate;
import java.util.List;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.entities.Sviluppatore;

public class GiocoDTO {
	private Long idGioco;
	private String titolo;
	private LocalDate dataUscita;
	private String serie;
	private int pegi;
	private Piattaforma piattaforma;
	private Genere genere;
	private Sviluppatore sviluppatore;
	private Editor editor;
	private List<GiocoRating> ratings;
	public Long getIdGioco() {
		return idGioco;
	}
	public void setIdGioco(Long idGioco) {
		this.idGioco = idGioco;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getDataUscita() {
		return dataUscita;
	}
	public void setDataUscita(LocalDate dataUscita) {
		this.dataUscita = dataUscita;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getPegi() {
		return pegi;
	}
	public void setPegi(int pegi) {
		this.pegi = pegi;
	}
	public Piattaforma getPiattaforma() {
		return piattaforma;
	}
	public void setPiattaforma(Piattaforma piattaforma) {
		this.piattaforma = piattaforma;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	public Sviluppatore getSviluppatore() {
		return sviluppatore;
	}
	public void setSviluppatore(Sviluppatore sviluppatore) {
		this.sviluppatore = sviluppatore;
	}
	public Editor getEditor() {
		return editor;
	}
	public void setEditor(Editor editor) {
		this.editor = editor;
	}
	public List<GiocoRating> getRatings() {
		return ratings;
	}
	public void setRatings(List<GiocoRating> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "GiocoDTO [idGioco=" + idGioco + ", titolo=" + titolo + ", dataUscita=" + dataUscita + ", serie=" + serie
				+ ", pegi=" + pegi + ", piattaforma=" + piattaforma + ", genere=" + genere + ", sviluppatore="
				+ sviluppatore + ", editor=" + editor + ", ratings=" + ratings + "]";
	}
}
