package com.g3.projectwork.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table // indica che si tratta di una tabella
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
	@Column(unique = true)
	private String userName;

	@Column(unique = true)
	private String emailAddress;

	private String pword;
	private String bio;
	private LocalDate dataIscrizione;
	private LocalDate dataCompleanno;

	public Utente() {

	}

	public Utente(String userName, String emailAddress, String pword, String bio, LocalDate dataIscrizione,
			LocalDate dataCompleanno) {
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.pword = pword;
		this.bio = bio;
		this.dataIscrizione = dataIscrizione;
		this.dataCompleanno = dataCompleanno;
	}

	public Utente(Long iDUtente, String userName, String emailAddress, String pword, String bio,
			LocalDate dataIscrizione, LocalDate dataCompleanno) {
		super();
		IDUtente = iDUtente;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.pword = pword;
		this.bio = bio;
		this.dataIscrizione = dataIscrizione;
		this.dataCompleanno = dataCompleanno;
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

	public String toString() {
		return "ID Utente: " + IDUtente + "\n" + "Username: " + userName + "\n" + "Password: " + pword + "\n"
				+ "Email: " + emailAddress + "\n" + "Bio: " + bio + "\n" + "Data Compleanno: " + dataCompleanno + "\n"
				+ "Data Iscrizione: " + dataIscrizione + "\n";
	}

}