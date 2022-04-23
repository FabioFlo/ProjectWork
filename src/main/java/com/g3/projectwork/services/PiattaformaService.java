package com.g3.projectwork.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.model.PiattaformaDTO;
import com.g3.projectwork.repos.PiattaformaRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class PiattaformaService {
	@Autowired
	private PiattaformaRepository piattaformaRepository;
	
	public List<PiattaformaDTO> getPiattaforme(){
		Iterable<Piattaforma> piattaformaList = piattaformaRepository.findAll();
		List<PiattaformaDTO> piattaformaDTOList = new ArrayList<>();
		for(Piattaforma piattaforma : piattaformaList) {
			PiattaformaDTO piattaformaDTO = new PiattaformaDTO();
			piattaformaDTO.setNomePiattaforma(piattaforma.getNomePiattaforma());
			piattaformaDTOList.add(piattaformaDTO);
		}
		return piattaformaDTOList;
	}
	
	public PiattaformaDTO getPiattaforma(Long IDPiattaforma) {
	Piattaforma piattaforma = piattaformaRepository.findById(IDPiattaforma).orElseThrow();
	PiattaformaDTO piattaformaDTO = new PiattaformaDTO();
		piattaformaDTO.setNomePiattaforma(piattaforma.getNomePiattaforma());
		return piattaformaDTO;
	}
	
	public GenericResponse createPiattaforma(PiattaformaDTO piattaforma) {
	Piattaforma s = new Piattaforma();
		s.setNomePiattaforma(piattaforma.getNomePiattaforma());
		piattaformaRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Piattaforma creato correttamente");
		return response;
	}
	
	public GenericResponse updatePiattaforma(Long IDPiattaforma, PiattaformaDTO piattaformaDTO) {
	Piattaforma s = piattaformaRepository.findById(IDPiattaforma).orElseThrow();
		s.setNomePiattaforma(piattaformaDTO.getNomePiattaforma());
		piattaformaRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Piattaforma modificato con successo");
		return response;
	}
	public GenericResponse deletePiattaforma(Long IDPiattaforma) {
	Piattaforma s = piattaformaRepository.findById(IDPiattaforma).orElseThrow();
		piattaformaRepository.delete(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Piattaforma eliminato correttamente");
		return response;
	}
}
