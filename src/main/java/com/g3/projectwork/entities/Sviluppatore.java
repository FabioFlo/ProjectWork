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
		name = "sviluppatori",
		uniqueConstraints =	@UniqueConstraint(
				name = "devName_unique",
				columnNames = "nomeSviluppatore"
				))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude= "giochi")
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

	@Column(name = "nomeSviluppatore")
	@NotBlank(message = "Nome Sviluppatore Necessario")
	private String nomeSviluppatore;

	@JsonIgnore
	@OneToMany(mappedBy = "sviluppatore")
	private List<Gioco> giochi;
}
