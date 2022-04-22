package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Sviluppatore 
{
	@Id
	@SequenceGenerator(
			name = "sviluppatore_sequence",
			sequenceName = "sviluppatore_sequence",
			allocationSize = 1
			) 
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "utente_sequence"
			)
	private Long IDSviluppatore;
	 @Column(unique = true)
	private String NomeSviluppatore;
	
	
	public Sviluppatore(Long iDSviluppatore, String nomeSviluppatore) 
	{
		super();
		IDSviluppatore = iDSviluppatore;
		NomeSviluppatore = nomeSviluppatore;
	}


	public Long getIDSviluppatore() 
	{
		return IDSviluppatore;
	}


	public void setIDSviluppatore(Long iDSviluppatore) 
	{
		IDSviluppatore = iDSviluppatore;
	}


	public String getNomeSviluppatore() 
	{
		return NomeSviluppatore;
	}


	public void setNomeSviluppatore(String nomeSviluppatore) 
	{
		NomeSviluppatore = nomeSviluppatore;
	}


	@Override
	public String toString()
	{
		return super.toString() 	  + 
				"IDSviluppatore: "    + IDSviluppatore   + "\n" +
				"Nome Sviluppatore: " + NomeSviluppatore + "\n" ;
	}
	
	
	
	
}
