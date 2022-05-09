package com.g3.projectwork.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GiocoRatingKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "IDUtente")
	@Builder.Default
	Long IDUtente = 0L;
	
	@Column(name = "IDGioco")
	@Builder.Default
	Long IDGioco = 0L;
}
