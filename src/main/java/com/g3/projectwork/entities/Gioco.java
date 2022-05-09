package com.g3.projectwork.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(name = "giochi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Gioco 
{

	// con queste notazioni gli diciamo che è un ID ed è primary e autogenerato
	// Long come int ma più big
	@Id @SequenceGenerator(
			name = "gioco_sequence",
			sequenceName = "gioco_sequence",
			allocationSize = 1
			)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "gioco_sequence"
			)
	private Long IDGioco;

	@Column(name = "titolo")
	@NotBlank(message = "Titolo Gioco Necessario")
	private String titolo;

	@Column(name = "dataUscita")	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataUscita;

	@Column(name = "serie")
	private String serie; 

	@Column(name = "pegi")
	@Max(value = 18)
	@Min(value = 3)
	private int pegi;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "IDPiattaforma", referencedColumnName = "IDPiattaforma")
	private Piattaforma piattaforma;


	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "IDGenere", referencedColumnName = "IDGenere")
	private Genere genere;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "IDSviluppatore", referencedColumnName = "IDSviluppatore")
	private Sviluppatore sviluppatore;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "IDEditor", referencedColumnName = "IDEditor")
	private Editor editor;

	@OneToMany(mappedBy= "gioco", cascade = CascadeType.ALL)
	private Set<GiocoRating> ratings;

	public double getAvgRating() {
		double avg = 0;
		if(!ratings.isEmpty()) {
			for(GiocoRating rating : ratings) {
				avg += rating.getRating();
			}
			avg/=ratings.size();
		}
		return avg;
	}
}
