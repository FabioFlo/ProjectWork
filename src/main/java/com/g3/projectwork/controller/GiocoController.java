package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.repos.GiocoRepository;

// Punto di riferimento per spring per gestire il servizio Rest
@RestController
public class GiocoController {

	private final GiocoRepository giocoRepository;

	GiocoController(GiocoRepository repository) {
		giocoRepository = repository;
	}
	
	// metodo per la lista giochi
	@GetMapping("/giochi")
	Iterable<Gioco> getGiochi(){
		return giocoRepository.findAll();
	}
	
	// metodo per un solo gioco
	@GetMapping("/giochi/{IDGioco}")
	Gioco getGioco(@PathVariable Long IDGioco) {
		return giocoRepository.findById(IDGioco).orElseThrow();
	}
	
	// metodo per creare un gioco
	@PostMapping("/giochi")
		Gioco createGioco(@RequestBody Gioco newGioco) {
		return giocoRepository.save(newGioco);
	}
	
	// metodo per aggiornare
	@PutMapping("/giochi/{IDGioco}")
	Gioco updateGioco(@PathVariable Long IDGioco, @RequestBody Gioco giocoDTO) {
		Gioco giocoDaAggiornare = giocoRepository.findById(IDGioco).orElseThrow();
		giocoDaAggiornare.setDataUscita(giocoDTO.getDataUscita());
		giocoDaAggiornare.setIDEditor(giocoDTO.getIDEditor());
		giocoDaAggiornare.setIDGenere(giocoDTO.getIDGenere());
		giocoDaAggiornare.setIDPiattaforma(giocoDTO.getIDPiattaforma());
		giocoDaAggiornare.setIDSviluppatore(giocoDTO.getIDSviluppatore());
		giocoDaAggiornare.setPegi(giocoDTO.getPegi());
		giocoDaAggiornare.setSerie(giocoDTO.getSerie());
		giocoDaAggiornare.setTitolo(giocoDTO.getTitolo());
		return giocoRepository.save(giocoDaAggiornare);
	}
	
	// metodo per eliminare
	@DeleteMapping("/giochi/{IDGioco}")
	void deletGioco(@PathVariable Long IDGioco) {
		Gioco gioco = giocoRepository.findById(IDGioco).orElseThrow();
		giocoRepository.delete(gioco);
	}
	
}
