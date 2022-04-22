package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.repos.GenereRepository;
import com.g3.projectwork.repos.PiattaformaRepository;
@RestController
public class GenereController {
private final GenereRepository genereRepository;
	
	GenereController(GenereRepository repository) {
		genereRepository = repository;
	}
	
	//tutta la lista piattaforme
	@GetMapping("/genere")
	Iterable<Genere> getGenere(){
		return genereRepository.findAll();
	}
	
	//una piattaforma
	@GetMapping("/Genere/{IDGenere}")
	Genere getGenere(@PathVariable Long IDGenere) {
		return genereRepository.findById(IDGenere).orElseThrow();
	}
	
	//create
	@PostMapping("/genere")
	Genere createGenere(@RequestBody Genere newGenere) {
		return genereRepository.save(newGenere);
	}
	
	//TODO mo lo finisco appena ho le entities (Genere)
	//update
	@PutMapping("/genere/{IDGenere}")
	Genere updateGenere(@PathVariable Long IDGenere, @RequestBody Genere genereDTO) {
		Genere genereDaAggiornare = genereRepository.findById(IDGenere).orElseThrow();
		//genereDaAggiornare.set
		return genereRepository.save(genereDaAggiornare);
	}
	
	//delete
	@DeleteMapping("/genere/{IDGenere}")
	void deleteGenere(@PathVariable Long IDGenere) {
		Genere genere = genereRepository.findById(IDGenere).orElseThrow();
		genereRepository.delete(genere);
	}
	
}
