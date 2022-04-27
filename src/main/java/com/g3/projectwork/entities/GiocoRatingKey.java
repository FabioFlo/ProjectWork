package com.g3.projectwork.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * Composite Key Per I Dati Associati sia al gioco che all'utente
 * Ha Bisogno di Embeddable Serializable HashCode() e Equals()
 */

@Embeddable
public class GiocoRatingKey implements Serializable{
	
	@Column(name = "IDUtente")
	Long IDUtente;
	
	@Column(name = "IDGioco")
	Long IDGioco;
	
	public GiocoRatingKey() {
	
	}

	public GiocoRatingKey(Long iDUtente, Long iDGioco) {
		super();
		IDUtente = iDUtente;
		IDGioco = iDGioco;
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
	public int hashCode() {
		return Objects.hash(IDGioco, IDUtente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiocoRatingKey other = (GiocoRatingKey) obj;
		return Objects.equals(IDGioco, other.IDGioco) && Objects.equals(IDUtente, other.IDUtente);
	}
	
}
