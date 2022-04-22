package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Sviluppatore;
import com.g3.projectwork.repos.SviluppatoreRepository;

@RestController
public class SviluppatoreController {
private final SviluppatoreRepository sviluppatoreRepository;
	
	SviluppatoreController(SviluppatoreRepository repository) {
		sviluppatoreRepository = repository;
	}
	
	//lista Sviluppatori
	@GetMapping("/sviluppatori")
	Iterable<Sviluppatore> getSviluppatore(){
		return sviluppatoreRepository.findAll();
	}
	
	//uno Sviluppatore
	@GetMapping("/sviluppatori/{IDSviluppatore}")
	Sviluppatore getSviluppatore(@PathVariable Long IDSviluppatore) {
		return sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
	}
	
	//create Sviluppatore
	@PostMapping("/sviluppatori")
	Sviluppatore createSviluppatore(@RequestBody Sviluppatore newSviluppatore) {
		return sviluppatoreRepository.save(newSviluppatore);
	}
	
	//update Sviluppatore
	@PutMapping("/sviluppatori/{IDSviluppatore}")
	Sviluppatore updateSviluppatore(@PathVariable Long IDSviluppatore, @RequestBody Sviluppatore sviluppatoreDTO) {
	Sviluppatore sviluppatoreDaAggiornare = sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
	sviluppatoreDaAggiornare.setIDSviluppatore(sviluppatoreDTO.getIDSviluppatore());
	sviluppatoreDaAggiornare.setNomeSviluppatore(sviluppatoreDTO.getNomeSviluppatore());
	return sviluppatoreRepository.save(sviluppatoreDaAggiornare);
	}
	
	//delete Sviluppatore
	@DeleteMapping("/sviluppatori/{IDSviluppatore}")
	void deleteSviluppatore(@PathVariable Long IDSviluppatore) {
		Sviluppatore sviluppatore = sviluppatoreRepository.findById(IDSviluppatore).orElseThrow();
		sviluppatoreRepository.delete(sviluppatore);
	}
}
