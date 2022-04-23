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

import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.model.PiattaformaDTO;
import com.g3.projectwork.services.PiattaformaService;
import com.g3.projectwork.utility.GenericResponse;

@RestController
@RequestMapping(path = "api/piattaforma")
public class PiattaformaController {
	
	@Autowired
	private PiattaformaService piattaformaService;
	
	//lista Piattaforma
	@GetMapping("/piattaforma")
	private List<PiattaformaDTO> getPiattaforme(){
		return piattaformaService.getPiattaforme();
	}
	
	//uno Piattaforma
	@GetMapping("/piattaforma/{IDPiattaforma}")
	private PiattaformaDTO getPiattaforma(@PathVariable Long IDPiattaforma) {
		return piattaformaService.getPiattaforma(IDPiattaforma);
	}
	
	//create Piattaforma
	@PostMapping("/nuovaPiattaforma")
	private GenericResponse createPiattaforma(@RequestBody PiattaformaDTO newPiattaforma) {
		return piattaformaService.createPiattaforma(newPiattaforma);
	}
	
	//update Piattaforma
	@PutMapping("/piattaforma/{IDPiattaforma}")
	private GenericResponse updatePiattaforma(@PathVariable Long IDPiattaforma, @RequestBody PiattaformaDTO piattaformaDTO) {
		return piattaformaService.updatePiattaforma(IDPiattaforma, piattaformaDTO);
	}
	
	//delete Piattaforma
	@DeleteMapping("/piattaforma/{IDPiattaforma}")
	private GenericResponse deletePiattaforma(@PathVariable Long IDPiattaforma) {
		return piattaformaService.deletePiattaforma(IDPiattaforma);
	}
}