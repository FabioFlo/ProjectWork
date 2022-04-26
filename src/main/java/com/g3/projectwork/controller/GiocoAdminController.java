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

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.repos.GiocoRepository;

@Controller
@RequestMapping(path = "/giochi")
public class GiocoAdminController {

	@Autowired
	private GiocoRepository giocoRepository;
	
	//SHOW PAGINA LISTA GIOCO
	@GetMapping("/listGioco")
	public String showGiocoList(Model model) {
		model.addAttribute("giochi", giocoRepository.findAll());
		return "gioco/AdminGiocoPage.html";
	}
	
	//SHOW PAGINA ADD GIOCO
	@GetMapping("/addGiocoPage")
	public String showAddGiocoPage(Model model) {
		model.addAttribute("gioco", new Gioco());
		return "gioco/addGiocoPage.html";
	}
	
	//CREATE
	@PostMapping("/addGioco")
	public String addGioco(@Valid Gioco gioco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "gioco/addGiocoPage.html";
		}
		giocoRepository.save(gioco);
		return "gioco/AdminGiocoPage.html";
	}
	
	//SHOW PAGINA UPDATE GIOCO
	@GetMapping("/edit/{id}")
	public String showUpdateGioco(@PathVariable("id") Long id, Model model) {
		Gioco gioco = giocoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID" + id +" non valido"));
		model.addAttribute("gioco", gioco);
		return "gioco/updateGiocoPage.html";
	}
	
	//UPDATE
	@PostMapping("/update/{id}")
	public String updateGioco(@PathVariable("id") Long id, @Valid Gioco gioco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			gioco.setIDGioco(id);
			return "gioco/updateGiocoPage.html";
		}
		gioco.setIDGioco(id);
		giocoRepository.save(gioco);
		return "gioco/AdminGiocoPage.html";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String deleteGioco(@PathVariable("id") Long id, Model model) {
		Gioco gioco = giocoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
		giocoRepository.delete(gioco);
		return "gioco/AdminGiocoPage.html";
	}
}