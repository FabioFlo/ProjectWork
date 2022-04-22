package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.repos.PiattaformaRepository;

@RestController
public class PiattaformaController {

	private final PiattaformaRepository piattaformaRepository;
	
	PiattaformaController(PiattaformaRepository repository) {
		piattaformaRepository = repository;
	}
	
	//tutta la lista piattaforme
	@GetMapping("/piattaforme")
	Iterable<Piattaforma> getPiattaforme(){
		return piattaformaRepository.findAll();
	}
	
	//una piattaforma
	@GetMapping("/piattaforme/{IDPiattaforma}")
	Piattaforma getPiattaforma(@PathVariable Long IDPiattaforma) {
		return piattaformaRepository.findById(IDPiattaforma).orElseThrow();
	}
	
	//create
	@PostMapping("/piattaforme")
	Piattaforma createPiattaforma(@RequestBody Piattaforma newPiattaforma) {
		return piattaformaRepository.save(newPiattaforma);
	}
	
	//TODO mo lo finisco appena ho le entities (Piattaforma)
	//update
	@PutMapping("/piattaforme/{IDPiattaforma}")
	Piattaforma updatePiattaforma(@PathVariable Long IDPiattaforma, @RequestBody Piattaforma piattaformaDTO) {
		Piattaforma piattaformaDaAggiornare = piattaformaRepository.findById(IDPiattaforma).orElseThrow();
		//piattaformaDaAggiornare.set
		return piattaformaRepository.save(piattaformaDaAggiornare);
	}
	
	//delete
	@DeleteMapping("/piattaforme/{IDPiattaforma")
	void deletePiattaforma(@PathVariable Long IDPiattaforma) {
		Piattaforma piattaforma = piattaformaRepository.findById(IDPiattaforma).orElseThrow();
		piattaformaRepository.delete(piattaforma);
	}
	
}
