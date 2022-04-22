package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Genere 
{
	@Id @SequenceGenerator(
			name = "genere_sequence",
			sequenceName = "genere_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "genere_sequence")
	private Long IDGenere;
	 @Column(unique = true)
	private String Genere;
	public Genere() {
		
	}
	public Genere(Long iDGenere, String genere) 
	{
		super();
		IDGenere = iDGenere;
		Genere = genere;
	}

	public Long getIDGenere()
	{
		return IDGenere;
	}

	public void setIDGenere(Long iDGenere) 
	{
		IDGenere = iDGenere;
	}

	public String getGenere() 
	{
		return Genere;
	}

	public void setGenere(String genere) 
	{
		Genere = genere;
	}

	@Override
	public String toString() 
	{
		return super.toString() +
				"IDGenere: " + IDGenere + "\n" + 
				"Genere: " 	 + Genere   + "\n" ;
	}
	
	
	
}
