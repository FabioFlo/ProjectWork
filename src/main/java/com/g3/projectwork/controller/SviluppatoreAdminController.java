package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g3.projectwork.entities.Sviluppatore;
import com.g3.projectwork.repos.SviluppatoreRepository;

@Controller
@RequestMapping(path = "/sviluppatori")
public class SviluppatoreAdminController {
	@Autowired
	private SviluppatoreRepository sviluppatoreRepository;
	
	@GetMapping("/listSviluppatore")
	public String showSviluppatoreList(Model model) {
		model.addAttribute("sviluppatori", sviluppatoreRepository.findAll());
		return "sviluppatore/AdminSviluppatorePage.html";
	}
	
	@GetMapping("/addSviluppatorePage")
	public String showAddSviluppatorePage(Model model) {
		model.addAttribute("sviluppatore", new Sviluppatore());
		return "sviluppatore/addSviluppatorePage.html";
	}
	
	@PostMapping("/addSviluppatore")
	public String addSviluppatore(@Valid Sviluppatore sviluppatore, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "addSviluppatorePage.html";
		}
		sviluppatoreRepository.save(sviluppatore);
		return "sviluppatore/AdminSviluppatorePage.html";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Sviluppatore sviluppatore = sviluppatoreRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID " + id + " non valido"));
		model.addAttribute("sviluppatore", sviluppatore);
		return "sviluppatore/updateSviluppatorePage.html";
	}
	
	@PostMapping("/update/{id}")
	public String updateSviluppatore(@PathVariable("id") Long id, @Valid Sviluppatore sviluppatore, BindingResult result, Model model) {
		if(result.hasErrors()) {
			sviluppatore.setIDSviluppatore(id);
			return "sviluppatore/updateSviluppatorePage.html";
		}
		sviluppatore.setIDSviluppatore(id);
		sviluppatoreRepository.save(sviluppatore);
		return "sviluppatore/AdminSviluppatorePage.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSviluppatore(@PathVariable("id") Long id, Model model) {
		Sviluppatore sviluppatore = sviluppatoreRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID "+ id + " non valido"));
		sviluppatoreRepository.delete(sviluppatore);
		return "sviluppatore/AdminSviluppatorePage.html";
	}
}
