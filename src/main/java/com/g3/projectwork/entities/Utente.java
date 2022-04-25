package com.g3.projectwork.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table // Indica che si tratta di una tabella
public class Utente {
	@Id // Diciamo inoltre che l'IDUtente è un id  e una primarykey
	@SequenceGenerator(
			// Diamo il nome che fa riferimento alla sequenza
			name = "utente_sequence", sequenceName = "utente_sequence",
			// Ogni volta che viene inserito un nuovo utente
			// L'id aumenta di 1
			allocationSize = 1)
	@GeneratedValue(
			// Con strategy indichiamo il tipo di azione che verrà eseguita
			// per generare la chiave primaria dell'@Entity
			strategy = GenerationType.SEQUENCE,
			// Indichiamo il nome a cui stiamo facendo riferimento
			generator = "utente_sequence")
	private Long IDUtente;
	
	// @NotBlank Questa notazione fa si che non possa essere accettato un inserimento di Utente se l'username è vuoto
	// @Size viene usata insieme a per indicare un intervallo di valori accettabile
	// @Column(unique = true) questa annotazione marchia come unico il valore
	// al momento della creazione della tabella, userName sarà unique e quindi non potranno esistere più utenti con lo stesso userName
	@NotBlank(message = "username obbligatorio") 
	@Size (min = 2, max = 10)
	@Column(unique = true)
	private String userName;
	
	// Stessa cosa per l'email, ma qui facciamo di più. In questo campo verrano
	// approvate SOLO email scritte in modo corretto.
	// @Email significa che non posso essere accettate delle stringhe generiche per esempio
	@NotBlank 
	@Email(message = "email non valida") 
	@Column(unique = true)
	private String emailAddress;
	
	@NotBlank(message = "password obbligatoria")
	@Size (min = 6, max = 32)
	private String pword;
	
	@Size (min = 0, max = 150)
	private String bio;
	
	// La notazione @Past non permette di accettare date che vadano oltre quella del giorno attuale.
	// Non accettiamo visitatori dal futuro, scusa :(
	@Past
	private LocalDate dataCompleanno;
	private LocalDate dataIscrizione;
	
	

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
