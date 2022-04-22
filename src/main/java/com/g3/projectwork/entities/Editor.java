package com.g3.projectwork.entities;

public class Editor 
{
	private Long IDEditor;
	private String NomeEditor;
	
	
	public Editor(Long iDEditor, String nomeEditor) 
	{
		super();
		IDEditor = iDEditor;
		NomeEditor = nomeEditor;
	}


	public Long getIDEditor() 
	{
		return IDEditor;
	}


	public void setIDEditor(Long iDEditor) 
	{
		IDEditor = iDEditor;
	}


	public String getNomeEditor()
	{
		return NomeEditor;
	}


	public void setNomeEditor(String nomeEditor) 
	{
		NomeEditor = nomeEditor;
	}


	@Override
	public String toString() 
	{
		return super.toString() +
				"IDEditor: "   + IDEditor   + "\n" +
				"Nome Editor:" + NomeEditor + "\n" ;
	}
	
	
	
}
