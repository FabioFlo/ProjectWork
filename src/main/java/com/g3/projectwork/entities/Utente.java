package com.g3.projectwork.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
		name = "utenti",
		uniqueConstraints =	@UniqueConstraint(
				name = "userNameAndMail_unique",
				columnNames = {"userName", "emailAddress"}
				)
		)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Utente {

	@Id
	@SequenceGenerator(
			name = "utente_sequence",
			sequenceName = "utente_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "utente_sequence"
			)
	private Long IDUtente;


	@Column(name = "userName")
	@NotBlank(message = "UserName Necessario")
	private String userName;

	@Column(
			name = "emailAddress",
			nullable = false
			)
	@NotBlank(message = "Email Necessaria")
	@Email
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
	
	@OneToMany(mappedBy= "utente", cascade = CascadeType.ALL)
	private List<GiocoRating> ratings;
}