package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Piattaforma
{
	@Id
	@SequenceGenerator(
			name = "piattaforma_sequence",
			sequenceName ="piattaforma_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "piattaforma_sequence"
			)
	
	private Long IDPiattaforma;
	 @Column(unique = true)
	private String Piattaforma;
	
	public Piattaforma(Long iDPiattaforma, String piattaforma)
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
