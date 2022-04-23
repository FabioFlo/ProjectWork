package com.g3.projectwork.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Sviluppatore;
import com.g3.projectwork.model.SviluppatoreDTO;
import com.g3.projectwork.repos.SviluppatoreRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class SviluppatoreService {
	
	@Autowired
	private SviluppatoreRepository sviluppatoreRepository;
	
	public List<SviluppatoreDTO> getSviluppatori(){
		Iterable<Sviluppatore> sviluppatoreList = sviluppatoreRepository.findAll();
		List<SviluppatoreDTO> sviluppatoreDTOList = new ArrayList<>();
		for(Sviluppatore sviluppatore : sviluppatoreList) {
			SviluppatoreDTO sviluppatoreDTO = new SviluppatoreDTO();
			sviluppatoreDTO.setNomeSviluppatore(sviluppatore.getNomeSviluppatore());
			sviluppatoreDTOList.add(sviluppatoreDTO);
		}
		return sviluppatoreDTOList;
	}
	
	public SviluppatoreDTO getSviluppatore(Long IDSviluppatore) {
		Sviluppatore sviluppatore = sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
		SviluppatoreDTO sviluppatoreDTO = new SviluppatoreDTO();
		sviluppatoreDTO.setNomeSviluppatore(sviluppatore.getNomeSviluppatore());
		return sviluppatoreDTO;
	}
	
	public GenericResponse createSviluppatore(SviluppatoreDTO sviluppatore) {
		Sviluppatore s = new Sviluppatore();
		s.setNomeSviluppatore(sviluppatore.getNomeSviluppatore());
		sviluppatoreRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Sviluppatore creato correttamente");
		return response;
	}
	
	public GenericResponse updateSviluppatore(Long IDSviluppatore, SviluppatoreDTO sviluppatoreDTO) {
		Sviluppatore s = sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
		s.setNomeSviluppatore(sviluppatoreDTO.getNomeSviluppatore());
		sviluppatoreRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Sviluppatore modificato con successo");
		return response;
	}
	public GenericResponse deleteSviluppatore(Long IDSviluppatore) {
		Sviluppatore s = sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
		sviluppatoreRepository.delete(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Sviluppatore eliminato correttamente");
		return response;
	}
}
