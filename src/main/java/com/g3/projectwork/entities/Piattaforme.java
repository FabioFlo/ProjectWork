package com.g3.projectwork.entities;

import javax.persistence.Column;


public class Piattaforme
{
	private Long IDPiattaforma;
	 @Column(unique = true)
	private String Piattaforma;
	
	public Piattaforme(Long iDPiattaforma, String piattaforma)
	{
		super();
		IDPiattaforma = iDPiattaforma;
		Piattaforma = piattaforma;
	}

	public Long getIDPiattaforma()
	{
		return IDPiattaforma;
	}

	public void setIDPiattaforma(Long iDPiattaforma) 
	{
		IDPiattaforma = iDPiattaforma;
	}

	public String getPiattaforma() 
	{
		return Piattaforma;
	}

	public void setPiattaforma(String piattaforma)
	{
		Piattaforma = piattaforma;
	}

	@Override
	public String toString()
	{
		return super.toString()   +
				"IDPiattaforma: " + IDPiattaforma + "\n" +
				"Piattaforma: "   + Piattaforma   + "\n" ;
	}
	
	
	
}
