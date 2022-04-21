package com.g3.projectwork.entities;

public class Generi 
{
	private Long IDGenere;
	private String Genere;
	
	public Generi(Long iDGenere, String genere) 
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
