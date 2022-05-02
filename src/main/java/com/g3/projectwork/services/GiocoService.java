package com.g3.projectwork.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.model.GiocoDTO;
import com.g3.projectwork.repos.GiocoRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class GiocoService {
	
	@Autowired
	private GiocoRepository giocoRepository;

	public List<GiocoDTO> getGiochi(){
		Iterable<Gioco> giocoList = giocoRepository.findAll();
		List<GiocoDTO> giocoDTOList = new ArrayList<>();
		for(Gioco gioco : giocoList) {
			GiocoDTO giocoDTO = new GiocoDTO();
			giocoDTO.setIdGioco(gioco.getIDGioco());
			giocoDTO.setTitolo(gioco.getTitolo());
			giocoDTO.setDataUscita(gioco.getDataUscita());
			giocoDTO.setSerie(gioco.getSerie());
			giocoDTO.setPegi(gioco.getPegi());
			giocoDTO.setEditor(gioco.getEditor());
			giocoDTO.setGenere(gioco.getGenere());
			giocoDTO.setPiattaforma(gioco.getPiattaforma());
			giocoDTO.setSviluppatore(gioco.getSviluppatore());
			giocoDTO.setRatings(gioco.getRatings());
			giocoDTOList.add(giocoDTO);
		}
		return giocoDTOList;
	}


	public GiocoDTO getGioco(Long IDGioco) {
		Gioco gioco = giocoRepository.findById(IDGioco)
				.orElseThrow();
		GiocoDTO giocoDTO = new GiocoDTO();
		giocoDTO.setIdGioco(IDGioco);
		giocoDTO.setTitolo(gioco.getTitolo());
		giocoDTO.setDataUscita(gioco.getDataUscita());
		giocoDTO.setSerie(gioco.getSerie());
		giocoDTO.setPegi(gioco.getPegi());
		giocoDTO.setEditor(gioco.getEditor());
		giocoDTO.setGenere(gioco.getGenere());
		giocoDTO.setPiattaforma(gioco.getPiattaforma());
		giocoDTO.setSviluppatore(gioco.getSviluppatore());
		giocoDTO.setRatings(gioco.getRatings());
		return giocoDTO;
	}
	
	public GenericResponse createGioco(GiocoDTO gioco) {
		Gioco g = new Gioco();
		g.setTitolo(gioco.getTitolo());
		g.setDataUscita(gioco.getDataUscita());
		g.setSerie(gioco.getSerie());
		g.setPegi(gioco.getPegi());
		g.setEditor(gioco.getEditor());
		g.setGenere(gioco.getGenere());
		g.setPiattaforma(gioco.getPiattaforma());
		g.setSviluppatore(gioco.getSviluppatore());
		g.setRatings(gioco.getRatings());
		giocoRepository.save(g);
		GenericResponse response = new GenericResponse();
				response.setMessage("Gioco creato correttamente");
		return response;
	}
	
	public GenericResponse updateGioco(Long IDGioco, GiocoDTO giocoDTO) {
		Gioco g = giocoRepository.findById(IDGioco).orElseThrow();
		g.setTitolo(giocoDTO.getTitolo());
		g.setDataUscita(giocoDTO.getDataUscita());
		g.setSerie(giocoDTO.getSerie());
		g.setPegi(giocoDTO.getPegi());
		g.setEditor(giocoDTO.getEditor());
		g.setGenere(giocoDTO.getGenere());
		g.setPiattaforma(giocoDTO.getPiattaforma());
		g.setSviluppatore(giocoDTO.getSviluppatore());
		g.setRatings(giocoDTO.getRatings());
		giocoRepository.save(g);
		GenericResponse response = new GenericResponse();
		response.setMessage("Gioco modificato correttamente");
		return response;
	}
	
	public GenericResponse deleteGioco(Long IDGioco) {
		Gioco gioco = giocoRepository.findById(IDGioco).orElseThrow();
		giocoRepository.delete(gioco);
		GenericResponse response = new GenericResponse();
		response.setMessage("Gioco eliminato correttamente");
		return response;
	}
}
