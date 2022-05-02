package com.g3.projectwork.model;

import java.time.LocalDate;
import java.util.List;

import com.g3.projectwork.entities.GiocoRating;

// UtenteDTO (DTO sta per Data Transfert Objects)
// che contiene gli stessi campi e può essere mandata in output
// (è proprio lo scopo delle classi DTO essere usate in questi passaggi)
// Questo per evitare che nel caso in cui la classe Entity abbia un dato che lo mette in join 
// con un altra classe Entity, vada a mandare in output tutti i dati congiunti
// In questo modo invece si lascia la possibilità mandare in output l'oggetto singolo e ben formattato
public class UtenteDTO {
	
	private Long id;
	private String userName;
	private String emailAddress;
	private String pword;
	private String bio;
	private LocalDate dataCompleanno;
	private LocalDate dataIscrizione;
	private List<GiocoRating> ratings;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public LocalDate getDataCompleanno() {
		return dataCompleanno;
	}
	public void setDataCompleanno(LocalDate dataCompleanno) {
		this.dataCompleanno = dataCompleanno;
	}

	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}
	
	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public List<GiocoRating> getRatings() {
		return ratings;
	}
	public void setRatings(List<GiocoRating> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "UtenteDTO [id=" + id + ", userName=" + userName + ", emailAddress=" + emailAddress + ", pword=" + pword
				+ ", bio=" + bio + ", dataCompleanno=" + dataCompleanno + ", dataIscrizione=" + dataIscrizione
				+ ", ratings=" + ratings + "]";
	}
}
