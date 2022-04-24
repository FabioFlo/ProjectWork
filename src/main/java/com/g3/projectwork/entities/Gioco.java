package com.g3.projectwork.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity // Usiamo la notazione @Entity per indicare la classe Gioco come oggetto
@Table
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
	private String titolo;
	private Date dataUscita;
	private String serie;
	private int pegi;
	private Long IDPiattaforma;
	private Long IDGenere;
	private Long IDSviluppatore;
	private Long IDEditor;
	
	
	public Gioco(String titolo, Date dataUscita, String serie, int pegi, Long iDPiattaforma, Long iDGenere,
			Long iDSviluppatore, Long iDEditor) 
	{
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

	//COSTRUTTORE SENZA DATA
	public Gioco(String titolo, String serie, int pegi, Long iDPiattaforma, Long iDGenere,
			Long iDSviluppatore, Long iDEditor) 
	{
		super();
		this.titolo = titolo;
		this.serie = serie;
		this.pegi = pegi;
		IDPiattaforma = iDPiattaforma;
		IDGenere = iDGenere;
		IDSviluppatore = iDSviluppatore;
		IDEditor = iDEditor;
	}
	public Gioco() 
	{
		
	}

	public Long getIDGioco() 
	{
		return IDGioco;
	}


	public void setIDGioco(Long iDGioco) 
	{
		IDGioco = iDGioco;
	}


	public String getTitolo()
{
		return titolo;
	}


	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}


	public Date getDataUscita() 
	{
		return dataUscita;
	}


	public void setDataUscita(Date dataUscita) 
	{
		this.dataUscita = dataUscita;
	}


	public String getSerie() 
	{
		return serie;
	}


	public void setSerie(String serie) 
	{
		this.serie = serie;
	}


	public int getPegi()
	{
		return pegi;
	}


	public void setPegi(int pegi) 
	{
		this.pegi = pegi;
	}


	public Long getIDPiattaforma() 
	{
		return IDPiattaforma;
	}


	public void setIDPiattaforma(Long iDPiattaforma)
	{
		IDPiattaforma = iDPiattaforma;
	}


	public Long getIDGenere() 
	{
		return IDGenere;
	}


	public void setIDGenere(Long iDGenere) 
	{
		IDGenere = iDGenere;
	}


	public Long getIDSviluppatore() 
	{
		return IDSviluppatore;
	}


	public void setIDSviluppatore(Long iDSviluppatore) 
	{
		IDSviluppatore = iDSviluppatore;
	}


	public Long getIDEditor() 
	{
		return IDEditor;
	}


	public void setIDEditor(Long iDEditor)
	{
		IDEditor = iDEditor;
	}

	@Override
	public String toString() 
	{
		return 
				super.toString() +
				"IDGioco: " 		+ IDGioco 		 + "\n" +
				"Titolo: " 			+ titolo 		 + "\n" + 
				"Data Uscita: " 	+ dataUscita 	 + "\n" +
				"Serie: " 			+ serie 		 + "\n" +
				"Pegi: " 			+ pegi 			 + "\n" + 
				"IDPiattaforma: "   + IDPiattaforma  + "\n" +
				"IDGenere: " 		+ IDGenere 		 + "\n" + 
				"IDSviluppatore: "  + IDSviluppatore + "\n" + 
				"IDEditor: " 		+ IDEditor   	 + "\n" ;
	}
	
	
	
	
}
