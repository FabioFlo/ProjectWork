package com.g3.projectwork.entities;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "IDPiattaforma")
	private Long IDPiattaforma;
	
	@Column(name = "IDGenere")
	private Long IDGenere;
	
	@Column(name = "IDSviluppatore")
	private Long IDSviluppatore;
	
	@Column(name = "IDEditor")
	private Long IDEditor;
	
	public Gioco() {
		
	}

	public Gioco(Long iDGioco, @NotBlank(message = "Titolo Gioco Necessario") String titolo, LocalDate dataUscita,
			String serie, @Min(3) @Max(18) int pegi, Long iDPiattaforma, Long iDGenere, Long iDSviluppatore,
			Long iDEditor) {
		super();
		IDGioco = iDGioco;
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.serie = serie;
		this.pegi = pegi;
		IDPiattaforma = iDPiattaforma;
		IDGenere = iDGenere;
		IDSviluppatore = iDSviluppatore;
		IDEditor = iDEditor;
	}



	public Gioco(Long iDGioco, @NotBlank(message = "Titolo Gioco Necessario") String titolo, LocalDate dataUscita,
			String serie, Long iDPiattaforma, Long iDGenere, Long iDSviluppatore, Long iDEditor) {
		super();
		IDGioco = iDGioco;
		this.titolo = titolo;
		this.dataUscita = dataUscita;
		this.serie = serie;
		IDPiattaforma = iDPiattaforma;
		IDGenere = iDGenere;
		IDSviluppatore = iDSviluppatore;
		IDEditor = iDEditor;
	}

	public Gioco(@NotBlank(message = "Titolo Gioco Necessario") String titolo, LocalDate dataUscita, String serie,
			@Min(3) @Max(18) int pegi, Long iDPiattaforma, Long iDGenere, Long iDSviluppatore, Long iDEditor) {
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

	@Override
	public String toString() {
		return super.toString() +
				"IDGioco: "        + IDGioco        + "\n" +
				"Titolo: "         + titolo         + "\n" +
				"Data di Uscita: " + dataUscita     + "\n" +
				"Serie: "          + serie          + "\n" +
				"pegi: "           + pegi           + "\n" +
				"IDPiattaforma: "  + IDPiattaforma  + "\n" +
				"IDGenere: "       + IDGenere       + "\n" +
				"IDSviluppatore: " + IDSviluppatore + "\n" +
				"IDEditor: "       + IDEditor       + "\n";
	}

}
