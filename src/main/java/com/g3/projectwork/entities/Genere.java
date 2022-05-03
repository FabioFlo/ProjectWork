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
		name = "generi",
		uniqueConstraints =	@UniqueConstraint(
				name = "genreName_unique",
				columnNames = "nomeGenere"
				))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude= "giochi")
public class Genere 
{
	@Id
	@SequenceGenerator(
			name = "genere_sequence",
			sequenceName = "genere_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "genere_sequence")
	private Long IDGenere;

	@Column(name = "nomeGenere")
	@NotBlank(message = "Nome Genere Necessario")
	private String nomeGenere;

	@JsonIgnore
	@OneToMany(mappedBy="genere")
	private List<Gioco> giochi;
}
