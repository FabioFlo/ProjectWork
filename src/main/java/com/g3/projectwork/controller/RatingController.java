package com.g3.projectwork.controller;

import javax.servlet.http.HttpSession;
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
import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.GiocoRatingKey;
import com.g3.projectwork.repos.GiocoRatingRepository;
import com.g3.projectwork.repos.GiocoRepository;
import com.g3.projectwork.repos.UtenteRepository;
import com.g3.projectwork.services.GiocoRatingService;

@Controller
@RequestMapping(path = "/ratings")
public class RatingController {
	
	@Autowired
	private GiocoRatingRepository ratingRepository;
	
	@Autowired 
	private GiocoRepository giocoRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private GiocoRatingService giocoService;
	
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
	public String showRatingForm(
			@PathVariable("idUtente") Long idUtente,
			@PathVariable("idGioco") Long idGioco,
			Model model) {
		GiocoRating giocoRating = new GiocoRating(
					new GiocoRatingKey(idUtente, idGioco),
					utenteRepository.getById(idUtente),
					giocoRepository.getById(idGioco)
					);
		System.out.println(utenteRepository.getById(idUtente).getUserName() + giocoRepository.getById(idGioco).getTitolo());
		
		System.out.println(giocoRating.getIDGiocoRating().getIDGioco() + giocoRating.getIDGiocoRating().getIDUtente());
		System.out.println("/n" + giocoRating.toString()+"/n");
		model.addAttribute("giocoRating",giocoRating);
		return "rating/ratingSubmissionForm.html";
	}
	
	@PostMapping("/saveRating/{idUtente}/gioco/{idGioco}")
	public String addDavveroRating(@Valid GiocoRating giocoRating,
									BindingResult result,
									@PathVariable("idUtente") Long idUtente,
									@PathVariable("idGioco") Long idGioco,
									Model model) {
		System.out.println("Sono entrato nel save");
		System.out.println(result.getModel());
//		if(result.hasErrors()) {
//			model.addAttribute("giocoRating",giocoRating);
//			return "rating/ratingSubmissionForm.html";
//		}
		giocoService.save(
				utenteRepository.getById(idUtente),
				giocoRepository.getById(idGioco),
				giocoRating.getRating(),
				giocoRating.getReviewText());
		return "rating/AdminRatingPage.html";
	}
}
