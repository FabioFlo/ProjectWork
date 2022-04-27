package com.g3.projectwork.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "utente")
public class Utente {
	@Id // diciamo inoltre che l'IDUtente è un id
	@SequenceGenerator(
			// diamo il nome che fa riferimento alla sequenza
			name = "utente_sequence", sequenceName = "utente_sequence",
			// ogni volta che viene inserito un nuovo utente
			// l'id aumenta di 1
			allocationSize = 1)
	@GeneratedValue(
			// Con strategy indichiamo il tipo di azione che verrà eseguita
			// per generare la chiave primaria dell'@Entity
			strategy = GenerationType.SEQUENCE,
			// inidichiamo il nome a cui stiamo facendo riferimento
			generator = "utente_sequence")
	private Long IDUtente;
	// questa annotazione marchia come unico il valore
	// al momento della creazione della tabella, userName sarà unique
	@Column(unique = true,
			name = "userName")
	@NotBlank(message = "UserName Necessario")
	private String userName;

	@Column(unique = true,
			name = "emailAddress")
	@NotBlank(message = "Email Necessaria")
	private String emailAddress;
	@Column(name = "pword")
	@NotBlank(message = "Password Necessaria")
	private String pword;
	@Column(name = "Bio",
			length = 150)
	private String bio;
	@Column(name = "dataIscrizione")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataIscrizione;
	@Column(name = "dataCompleanno")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataCompleanno;
	
	@OneToMany(mappedBy= "utente")
	List<GiocoRating> ratings;
	public Utente() {
		
	}
	public Utente(@NotBlank(message = "UserName Necessario") String userName,
			@NotBlank(message = "Email Necessaria") String emailAddress,
			@NotBlank(message = "Password Necessaria") String pword, String bio, LocalDate dataIscrizione,
			LocalDate dataCompleanno) {
		super();
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.pword = pword;
		this.bio = bio;
		this.dataIscrizione = dataIscrizione;
		this.dataCompleanno = dataCompleanno;
	}
	
	public Utente(@NotBlank(message = "UserName Necessario") String userName,
			@NotBlank(message = "Email Necessaria") String emailAddress,
			@NotBlank(message = "Password Necessaria") String pword, String bio) {
		super();
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.pword = pword;
		this.bio = bio;
	}
	public Utente(Long iDUtente, @NotBlank(message = "UserName Necessario") String userName,
			@NotBlank(message = "Email Necessaria") String emailAddress,
			@NotBlank(message = "Password Necessaria") String pword, String bio, LocalDate dataIscrizione,
			LocalDate dataCompleanno) {
		super();
		IDUtente = iDUtente;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.pword = pword;
		this.bio = bio;
		this.dataIscrizione = dataIscrizione;
		this.dataCompleanno = dataCompleanno;
	}
	public Long getIDUtente() {
		return IDUtente;
	}
	public void setIDUtente(Long iDUtente) {
		IDUtente = iDUtente;
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
	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public LocalDate getDataCompleanno() {
		return dataCompleanno;
	}
	public void setDataCompleanno(LocalDate dataCompleanno) {
		this.dataCompleanno = dataCompleanno;
	}
	@Override
	public String toString() {
		return "Utente [IDUtente=" + IDUtente + ", userName=" + userName + ", emailAddress=" + emailAddress + ", pword="
				+ pword + ", bio=" + bio + ", dataIscrizione=" + dataIscrizione + ", dataCompleanno=" + dataCompleanno
				+ "]";
	}
}