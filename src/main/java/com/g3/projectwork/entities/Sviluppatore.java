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
@Table(name = "sviluppatore")
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
			generator = "sviluppatore_sequence"
			)
	private Long IDSviluppatore;
	 @Column(unique = true)
	private String nomeSviluppatore;
	
	@OneToMany(mappedBy = "sviluppatore")
	private List<Gioco> giochi;
	
	public Sviluppatore() {
		
	}
	public Sviluppatore(Long iDSviluppatore, String nomeSviluppatore) 
	{
		super();
		IDSviluppatore = iDSviluppatore;
		this.nomeSviluppatore = nomeSviluppatore;
	}
	public Sviluppatore(String nomeSviluppatore) {
		this.nomeSviluppatore = nomeSviluppatore;
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
		return nomeSviluppatore;
	}


	public void setNomeSviluppatore(String nomeSviluppatore) 
	{
		this.nomeSviluppatore = nomeSviluppatore;
	}


	@Override
	public String toString()
	{
		return super.toString() 	  + 
				"IDSviluppatore: "    + IDSviluppatore   + "\n" +
				"Nome Sviluppatore: " + nomeSviluppatore + "\n" ;
	}
}
