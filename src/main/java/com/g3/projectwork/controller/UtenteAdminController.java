package com.g3.projectwork.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g3.projectwork.entities.Utente;
import com.g3.projectwork.repos.UtenteRepository;

@Controller
@RequestMapping("/utenti")
public class UtenteAdminController {
	@Autowired
	private UtenteRepository utentiRepository;
	
	//SHOW PAGINA LISTA UTENTI
	@GetMapping("/listUtenti")
	public String showUserList(Model model) {
		model.addAttribute("utenti", utentiRepository.findAll());
		return "utente/AdminUtentiPage.html";
	}
	
	//SHOW PAGINA ADD UTENTE
	@GetMapping("/addUtentePage")
	public String showAddUtentePage(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("localDateNow", LocalDateTime.now());
		return "utente/addUtentePage.html";
	}
	
	//CREATE UTENTE
	@PostMapping("/addUtente")
	public String addUtente(@Valid Utente utente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "utente/addUtentePage.html";
		}
		utentiRepository.save(utente);
		return "utente/AdminUtentiPage.html";
	}
	
	//SHOW PAGINA UPDATE
	@GetMapping("/edit/{id}")
	public String showUpdateUtenteForm(@PathVariable("id") Long id, Model model) {
		Utente utente = utentiRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
		model.addAttribute("utente", utente);
		return "utente/updateUtentePage.html";
	}
	
	//UPDATE
	@PostMapping("/update/{id}")
	public String updateUtente(@PathVariable("id") Long id, @Valid Utente utente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			utente.setIDUtente(id);
			return "utente/updateUtentePage.html";
		}
		utente.setIDUtente(id);
		utentiRepository.save(utente);
		return "utente/AdminUtentiPage.html";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String deleteUtente(@PathVariable("id")Long id, Model model) {
		Utente utente = utentiRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
		utentiRepository.delete(utente);
		return "utente/AdminUtentiPage.html";
	}
}
