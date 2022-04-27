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
@Table (name ="piattaforma")
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
	private String nomePiattaforma;
	
	@OneToMany(mappedBy="piattaforma")
	private List<Gioco> giochi;
	
	public Piattaforma() {
		
	}
	public Piattaforma(Long iDPiattaforma, String piattaforma)
	{
		super();
		IDPiattaforma = iDPiattaforma;
		nomePiattaforma = piattaforma;
	}

	public Long getIDPiattaforma()
	{
		return IDPiattaforma;
	}

	public void setIDPiattaforma(Long iDPiattaforma) 
	{
		IDPiattaforma = iDPiattaforma;
	}

	public String getNomePiattaforma() 
	{
		return nomePiattaforma;
	}

	public void setNomePiattaforma(String piattaforma)
	{
		nomePiattaforma = piattaforma;
	}

	@Override
	public String toString()
	{
		return super.toString()   +
				"IDPiattaforma: " + IDPiattaforma + "\n" +
				"Piattaforma: "   + nomePiattaforma   + "\n" ;
	}
	
	
	
}
