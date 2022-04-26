package com.g3.projectwork.restcontroller;

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

import com.g3.projectwork.model.SviluppatoreDTO;
import com.g3.projectwork.services.SviluppatoreService;
import com.g3.projectwork.utility.GenericResponse;

@RestController
@RequestMapping(path = "api/sviluppatore")
public class SviluppatoreController {
	
	@Autowired
	private SviluppatoreService sviluppatoreService;
	
	//lista Sviluppatori
	@GetMapping("/sviluppatori")
	private List<SviluppatoreDTO> getSviluppatore(){
		return sviluppatoreService.getSviluppatori();
	}
	
	//uno Sviluppatore
	@GetMapping("/sviluppatori/{IDSviluppatore}")
	private SviluppatoreDTO getSviluppatore(@PathVariable Long IDSviluppatore) {
		return sviluppatoreService.getSviluppatore(IDSviluppatore);
	}
	
	//create Sviluppatore
	@PostMapping("/nuovoSviluppatore")
	private GenericResponse createSviluppatore(@RequestBody SviluppatoreDTO newSviluppatore) {
		return sviluppatoreService.createSviluppatore(newSviluppatore);
	}
	
	//update Sviluppatore
	@PutMapping("/sviluppatori/{IDSviluppatore}")
	private GenericResponse updateSviluppatore(@PathVariable Long IDSviluppatore, @RequestBody SviluppatoreDTO sviluppatoreDTO) {
		return sviluppatoreService.updateSviluppatore(IDSviluppatore, sviluppatoreDTO);
	}
	
	//delete Sviluppatore
	@DeleteMapping("/sviluppatori/{IDSviluppatore}")
	private GenericResponse deleteSviluppatore(@PathVariable Long IDSviluppatore) {
		return sviluppatoreService.deleteSviluppatore(IDSviluppatore);
	}
}
