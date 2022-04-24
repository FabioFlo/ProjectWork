package com.g3.projectwork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Editor 
{
	@Id 
	@SequenceGenerator(
	name = "editor_sequence",
	sequenceName = "editor_sequence",
	allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "editor_sequence"
			)
	private Long IDEditor;
	 @Column(unique = true)
	private String NomeEditor;
	
	public Editor() {
		
	}
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
