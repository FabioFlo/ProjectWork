package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.repos.GenereRepository;
@RestController
public class GenereController {
private final GenereRepository genereRepository;
	
	GenereController(GenereRepository repository) {
		genereRepository = repository;
	}
	
	//tutta la lista piattaforme
	@GetMapping("/generi")
	Iterable<Genere> getGenere(){
		return genereRepository.findAll();
	}
	
	//una piattaforma
	@GetMapping("/generi/{IDGenere}")
	Genere getGenere(@PathVariable Long IDGenere) {
		return genereRepository.findById(IDGenere).orElseThrow();
	}
	
	//create
	@PostMapping("/generi")
	Genere createGenere(@RequestBody Genere newGenere) {
		return genereRepository.save(newGenere);
	}
	
	//update
	@PutMapping("/generi/{IDGenere}")
	Genere updateGenere(@PathVariable Long IDGenere, @RequestBody Genere genereDTO) {
		Genere genereDaAggiornare = genereRepository.findById(IDGenere).orElseThrow();
		genereDaAggiornare.setIDGenere(genereDTO.getIDGenere());
		genereDaAggiornare.setGenere(genereDTO.getGenere());
		return genereRepository.save(genereDaAggiornare);
	}
	
	//delete
	@DeleteMapping("/generi/{IDGenere}")
	void deleteGenere(@PathVariable Long IDGenere) {
		Genere genere = genereRepository.findById(IDGenere).orElseThrow();
		genereRepository.delete(genere);
	}
	
}
