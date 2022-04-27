package com.g3.projectwork.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "genere")
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
	private String nomeGenere;
	
	@OneToMany(mappedBy="genere")
	private List<Gioco> giochi;
	
	
	public Genere() {
		
	}
	public Genere(Long iDGenere, String genere) 
	{
		super();
		IDGenere = iDGenere;
		nomeGenere = genere;
	}

	public Long getIDGenere()
	{
		return IDGenere;
	}

	public void setIDGenere(Long iDGenere) 
	{
		IDGenere = iDGenere;
	}

	public String getNomeGenere() 
	{
		return nomeGenere;
	}

	public void setNomeGenere(String genere) 
	{
		nomeGenere = genere;
	}

	@Override
	public String toString() 
	{
		return super.toString() +
				"IDGenere: " + IDGenere + "\n" + 
				"Genere: " 	 + nomeGenere   + "\n" ;
	}
}
