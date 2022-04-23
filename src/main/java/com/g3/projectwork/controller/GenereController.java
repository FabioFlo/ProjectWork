package com.g3.projectwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.model.GenereDTO;
import com.g3.projectwork.services.GenereService;
import com.g3.projectwork.utility.GenericResponse;

@RestController
@RequestMapping(path = "api/genere")
public class GenereController {
	
	@Autowired
	private GenereService genereService;
	
	//lista Genere
	@GetMapping("/genere")
	private List<GenereDTO> getGeneri(){
		return genereService.getGeneri();
	}
	
	//uno Genere
	@GetMapping("/genere/{IDGenere}")
	private GenereDTO getGenere(@PathVariable Long IDGenere) {
		return genereService.getGenere(IDGenere);
	}
	
	//create Genere
	@PostMapping("/nuovoGenere")
	private GenericResponse createGenere(@RequestBody GenereDTO newGenere) {
		return genereService.createGenere(newGenere);
	}
	
	//update Genere
	@PutMapping("/genere/{IDGenere}")
	private GenericResponse updateGenere(@PathVariable Long IDGenere, @RequestBody GenereDTO genereDTO) {
		return genereService.updateGenere(IDGenere, genereDTO);
	}
	
	//delete Genere
	@DeleteMapping("/genere/{IDGenere}")
	private GenericResponse deleteGenere(@PathVariable Long IDGenere) {
		return genereService.deleteGenere(IDGenere);
	}
}