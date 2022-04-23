package com.g3.projectwork.model;

public class SviluppatoreDTO {
	
	private Long IDSviluppatore;
	private String nomeSviluppatore;
	
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