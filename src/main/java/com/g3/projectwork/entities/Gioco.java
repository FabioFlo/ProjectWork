package com.g3.projectwork.entities;

import java.time.LocalDate;
import java.util.List;

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


@Entity 
@Table(name = "gioco") 
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

	@OneToMany(mappedBy= "gioco")
	List<GiocoRating> ratings;
	public Gioco() {

	}

	public Gioco(Long iDGioco, @NotBlank(message = "Titolo Gioco Necessario") String titolo, LocalDate dataUscita,
			String serie, @Max(18) @Min(3) int pegi, Piattaforma piattaforma, Genere genere, Sviluppatore sviluppatore,
			Editor editor) {
		super();
		IDGioco = iDGioco;
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.serie = serie;
		this.pegi = pegi;
		this.piattaforma = piattaforma;
		this.genere = genere;
		this.sviluppatore = sviluppatore;
		this.editor = editor;
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

	public void assignEditor(Editor editor) {
		this.editor = editor;
	}

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
	@Override
	public String toString() {
		return "Gioco [IDGioco=" + IDGioco + ", titolo=" + titolo + ", dataUscita=" + dataUscita + ", serie=" + serie
				+ ", pegi=" + pegi + ", piattaforma=" + piattaforma + ", genere=" + genere + ", sviluppatore="
				+ sviluppatore + ", editor=" + editor + "]";
	}

}
