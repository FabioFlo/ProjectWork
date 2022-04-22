package com.g3.projectwork.entities;

public class Sviluppatori 
{
	private Long IDSviluppatore;
	private String NomeSviluppatore;
	
	
	public Sviluppatori(Long iDSviluppatore, String nomeSviluppatore) 
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
