package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.repos.GenereRepository;

public class GenereAdminController {

	@Autowired
	private GenereRepository genereRepository;
	
	@GetMapping("/listGenere")
	public String showGenereList(Model model) {
		model.addAttribute("generi", genereRepository.findAll());
		return "AdminGenerePage.html";
		//TODO: creare AdminGenerePage.html
	}
	
	@GetMapping("/addGenerePage")
	public String showAddGenerePage(Model model) {
		model.addAttribute("genere", new Genere());
		return "addGenerePage.html";
		//TODO: creare addGenerePage.html
	}
	
	@PostMapping("/addGenere")
	public String addGenere(@Valid Genere genere, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "addGenerePage.html";
		}
		genereRepository.save(genere);
		return "AdminGenerePage.html";
		//TODO: AdminGenerePage.html
	}
	
	@GetMapping("/genere/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Genere genere = genereRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID " + id + " non valido"));
		model.addAttribute("genere", genere);
		return "updateGenerePage.html";
		//TODO: updateGenerePage.html
	}
	
	@PostMapping("/update/{id}")
	public String updateGenere(@PathVariable("id") Long id, @Valid Genere genere, BindingResult result, Model model) {
		if(result.hasErrors()) {
			genere.setIDGenere(id);
			return "updateGenerePage.html";
		}
		genere.setIDGenere(id);
		genereRepository.save(genere);
		return "AdminGenerePage.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteGenere(@PathVariable("id") Long id, Model model) {
		Genere genere = genereRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID "+ id + " non valido"));
		genereRepository.delete(genere);
		return "AdminGenerePage.html";
	}
	
}
