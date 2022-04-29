package com.g3.projectwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.repos.GiocoRepository;

@Controller
public class SearchController {

	@Autowired
	GiocoRepository giocoRepository;

	@GetMapping("/search")
	public String searchByWord(@RequestParam(value="word") String word, Model model)
	{
		String redirect = "";
		//ESCLUDO PAROLE NULLE
		if(word==null || word.isBlank() || word.isEmpty()) {
			System.out.println("PAROLA NULLA O VUOTA");
			redirect = "redirect:/giochi/listGioco";
		}else {
			//SE HO PAROLE CONTROLLO I GIOCHI
			List<Gioco> giochi = giocoRepository.findByTitoloContaining(word);
			if(giochi.isEmpty() || giochi == null) {
				System.out.println("LISTA NULLA O VUOTA");
				redirect = "redirect:/giochi/listGioco";
			} //SE HO I GIOCHI LI ASSEGNO AL MODEL E RICARICO ADMINGIOCOPAGE MA PASSANDOGLI UN MODELLO
			else {
				model.addAttribute("giochi", giochi);
				redirect = "/gioco/AdminGiocoPage.html";
			}
		}
		return redirect;
	}
}
