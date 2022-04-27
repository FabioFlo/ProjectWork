package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.repos.PiattaformaRepository;


public class PiattaformaAdminController {
	@Autowired
	private PiattaformaRepository piattaformaRepository;
	
	@GetMapping("/listPiattaforma")
	public String showPiattaformaList(Model model) {
		model.addAttribute("piattaforme", piattaformaRepository.findAll());
		return "AdminPiattaformaPage.html";
		//TODO: creare AdminPiattaformaPage.html
	}
	
	@GetMapping("/addPiattaformaPage")
	public String showAddPiattaformaPage(Model model) {
		model.addAttribute("piattaforma", new Piattaforma());
		return "addPiattaformaPage.html";
		//TODO: creare addPiattaformaPage.html
	}
	
	@PostMapping("/addPiattaforma")
	public String addPiattaforma(@Valid Piattaforma piattaforma, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "addPiattaformaPage.html";
		}
		piattaformaRepository.save(piattaforma);
		return "AdminPiattaformaPage.html";
		//TODO: AdminPiattaformaPage.html
	}
	
	@GetMapping("/piattaforma/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Piattaforma piattaforma = piattaformaRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID " + id + " non valido"));
		model.addAttribute("piattaforma", piattaforma);
		return "updatePiattaformaPage.html";
		//TODO: updatePiattaformaPage.html
	}
	
	@PostMapping("/update/{id}")
	public String updatePiattaforma(@PathVariable("id") Long id, @Valid Piattaforma piattaforma, BindingResult result, Model model) {
		if(result.hasErrors()) {
			piattaforma.setIDPiattaforma(id);
			return "updatePiattaformaPage.html";
		}
		piattaforma.setIDPiattaforma(id);
		piattaformaRepository.save(piattaforma);
		return "AdminPiattaformaPage.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePiattaforma(@PathVariable("id") Long id, Model model) {
		Piattaforma piattaforma = piattaformaRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID "+ id + " non valido"));
		piattaformaRepository.delete(piattaforma);
		return "AdminPiattaformaPage.html";
	}
}
