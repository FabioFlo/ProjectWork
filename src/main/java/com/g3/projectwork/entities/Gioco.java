package com.g3.projectwork.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity // Usiamo la notazione @Entity per indicare la classe Gioco come oggetto
public class Gioco {

	// con queste notazioni gli diciamo che è un ID ed è primary e autogenerato
	// Long come int ma più big
	private @Id @GeneratedValue Long IDGioco;
	private String titolo;
	private LocalDate dataUscita;
	private String serie;
	private int pegi;
	private Long IDPiattaforma;
	private Long IDGenere;
	private Long IDSviluppatore;
	private Long IDEditor;
	
	public Gioco(String titolo, LocalDate dataUscita, String serie, int pegi, Long iDPiattaforma, Long iDGenere,
			Long iDSviluppatore, Long iDEditor) {
		super();
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.serie = serie;
		this.pegi = pegi;
		IDPiattaforma = iDPiattaforma;
		IDGenere = iDGenere;
		IDSviluppatore = iDSviluppatore;
		IDEditor = iDEditor;
	}

	public Gioco() {
		
	}

	public Long getIDGioco() {
		return IDGioco;
	}

	public void setIDGioco(Long iDGioco) {
		IDGioco = iDGioco;
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

	public Long getIDPiattaforma() {
		return IDPiattaforma;
	}

	public void setIDPiattaforma(Long iDPiattaforma) {
		IDPiattaforma = iDPiattaforma;
	}

	public Long getIDGenere() {
		return IDGenere;
	}

	public void setIDGenere(Long iDGenere) {
		IDGenere = iDGenere;
	}

	public Long getIDSviluppatore() {
		return IDSviluppatore;
	}

	public void setIDSviluppatore(Long iDSviluppatore) {
		IDSviluppatore = iDSviluppatore;
	}

	public Long getIDEditor() {
		return IDEditor;
	}

	public void setIDEditor(Long iDEditor) {
		IDEditor = iDEditor;
	}
	
}
