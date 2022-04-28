package com.g3.projectwork.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.repos.GiocoRatingRepository;
import com.g3.projectwork.repos.GiocoRepository;

@Controller
@RequestMapping(path = "/ratings")
public class RatingController {
	
	@Autowired
	private GiocoRatingRepository ratingRepository;
	
	@Autowired 
	private GiocoRepository giocoRepository;
	
	//SHOW RATING
	@GetMapping("/listRating")
	public String showRatingList(Model model) {
		model.addAttribute("ratings", ratingRepository.findAll());
		return "rating/AdminRatingPage.html";
	}
	
	
	//SHOW ADD RATING PAGE
	@GetMapping("/addRatingPage")
	public String showAddRatingPage(HttpSession session,Model model) {
		model.addAttribute("giocoRating", new GiocoRating());
		model.addAttribute("giochi", giocoRepository.findAll());
		model.addAttribute("sessionIDUtente", session.getAttribute("sessionIDUtente"));
		System.out.println(model.getAttribute("sessionIDUtente" + model.getAttribute("giochi")));
		return "rating/selectGameRatingPage.html";
	}
	
	//SHOW FORM RECENSIONE
	@GetMapping("/addRating/{idUtente}/gioco/{idGioco}")
	public String showRatingForm(
			@PathVariable("idUtente") Long idUtente,
			@PathVariable("idGioco") Long idGioco	) {
		//MOSTRO IL FORM CON I VALORI DEL GIOCO SELEZIONATO IN SHOW ADD RATING PAGE
		return "";
	}
	@GetMapping("/addRating")
	public String addDavveroRating() {
		//TODO: MARCOOOOOOOOOOOOOOOOOOO
		//Abbiamo risolto, non avevamo importato thymeleaf sul html e abbiamo sbagliato una parentesi
		//Benvenuto nel mio mondo
		//Se vuoi provare a fare il metodo di Add, basta che segui le indicazioni per come abbiamo fatto nell'editor controller o nell'utente
		//Questo addDavvero Rating è quello che deve fare il save tramite la repository
		//nel metodo prima va mostrato il form per inserire voto e testo della review
		return "";
	}
}
