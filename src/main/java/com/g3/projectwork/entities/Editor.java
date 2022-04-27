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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "editor")
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
	 @Column(unique = true, name ="nomeEditor")
	 @NotBlank(message = "Nome Editor Necessario") //Questa annotazione serve per la validazione degli elementi inseriti, l'istanziazione non prosegue se viene individuato un nome "blank"
	private String nomeEditor;
	 
	@JsonIgnore
	@OneToMany(mappedBy = "editor")
	private List<Gioco> giochi;
	public Editor() {
		
	}
	public Editor(Long iDEditor, String nomeEditor) 
	{
		super();
		IDEditor = iDEditor;
		this.nomeEditor = nomeEditor;
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
		return nomeEditor;
	}


	public void setNomeEditor(String nomeEditor) 
	{
		this.nomeEditor = nomeEditor;
	}

	@Override
	public String toString() 
	{
		return super.toString() +
				"IDEditor: "   + IDEditor   + "\n" +
				"Nome Editor:" + nomeEditor + "\n" ;
	}
}
