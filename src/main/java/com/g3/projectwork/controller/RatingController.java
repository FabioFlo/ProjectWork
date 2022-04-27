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
		return "rating/selectGameRatingPage.html";
	}
	
	//SHOW FORM RECENSIONE
	@GetMapping("/addRating/{idUtente}/gioco/{idGioco}")
	public String showRatingForm() {
		//MOSTRO IL FORM CON I VALORI DEL GIOCO SELEZIONATO IN SHOW ADD RATING PAGE
		return "";
	}
	@GetMapping("/addRating")
	public String addDavveroRating() {
		
		return "";
	}
}
