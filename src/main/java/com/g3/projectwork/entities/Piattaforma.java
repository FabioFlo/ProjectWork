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
@Table (
		name ="piattaforme",
		uniqueConstraints =	@UniqueConstraint(
				name = "platName_unique",
				columnNames = "nomePiattaforma"
				))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude= "giochi")
public class Piattaforma
{
	@Id
	@SequenceGenerator(
			name = "piattaforma_sequence",
			sequenceName ="piattaforma_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "piattaforma_sequence"
			)

	private Long IDPiattaforma;

	@Column(name = "nomePiattaforma")
	@NotBlank(message = "Nome Piattaforma Necessario")
	private String nomePiattaforma;
	
	@JsonIgnore
	@OneToMany(mappedBy="piattaforma")
	private List<Gioco> giochi;
}
