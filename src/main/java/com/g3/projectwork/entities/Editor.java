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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
		name= "editors",
		uniqueConstraints =	@UniqueConstraint(
				name = "editName_unique",
				columnNames = "nomeEditor"
				))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude= "giochi")
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
	
	@Column(name ="nomeEditor")
	@NotBlank(message = "Nome Editor Necessario")
	private String nomeEditor;
	 
	@JsonIgnore
	@OneToMany(mappedBy = "editor")
	private List<Gioco> giochi;
}
