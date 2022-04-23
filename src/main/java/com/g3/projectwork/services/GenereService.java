package com.g3.projectwork.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.model.GenereDTO;
import com.g3.projectwork.repos.GenereRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class GenereService {
	
	@Autowired
	private GenereRepository genereRepository;
	
	public List<GenereDTO> getGeneri(){
		Iterable<Genere> genereList = genereRepository.findAll();
		List<GenereDTO> genereDTOList = new ArrayList<>();
		for(Genere genere : genereList) {
			GenereDTO genereDTO = new GenereDTO();
			genereDTO.setNomeGenere(genere.getNomeGenere());
			genereDTOList.add(genereDTO);
		}
		return genereDTOList;
	}
	
	public GenereDTO getGenere(Long IDGenere) {
		Genere genere = genereRepository.findById(IDGenere).orElseThrow();
		GenereDTO genereDTO = new GenereDTO();
		genereDTO.setNomeGenere(genere.getNomeGenere());
		return genereDTO;
	}
	
	public GenericResponse createGenere(GenereDTO genere) {
		Genere s = new Genere();
		s.setNomeGenere(genere.getNomeGenere());
		genereRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Genere creato correttamente");
		return response;
	}
	
	public GenericResponse updateGenere(Long IDGenere, GenereDTO genereDTO) {
		Genere s = genereRepository.findById(IDGenere).orElseThrow();
		s.setNomeGenere(genereDTO.getNomeGenere());
		genereRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Genere modificato con successo");
		return response;
	}
	
	public GenericResponse deleteGenere(Long IDGenere) {
		Genere s = genereRepository.findById(IDGenere).orElseThrow();
		genereRepository.delete(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Genere eliminato correttamente");
		return response;
	}
}
