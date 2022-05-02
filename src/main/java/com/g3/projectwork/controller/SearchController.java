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
		}else
		{
			//SE HO PAROLE CONTROLLO I GIOCHI
			List<Gioco> giochi = giocoRepository.findByTitoloContaining(word);
			List<Gioco> giochiByEditor = giocoRepository.findByEditorContaining(word);
			List<Gioco> giochiByPiattaforma = giocoRepository.findByPiattaformaContaining(word);
			List<Gioco> giochiBySviluppatore = giocoRepository.findBySviluppatoreContaining(word);
			List<Gioco> giochiByGenere = giocoRepository.findByGenereContaining(word);
			if(giochi.isEmpty() || giochi == null) {
				System.out.println("LISTA Giochi NULLA O VUOTA");
				redirect = "redirect:/giochi/listGioco";
			}
			if
			(giochiByEditor.isEmpty() || giochiByEditor == null){
				System.out.println("LISTA Editor NULLA O VUOTA");
				// redirect = "redirect:/giochi/listGioco";
			}

			
			if(giochiByEditor.size() != 0 && giochiByEditor != null) {
				for(Gioco ge : giochiByEditor) {
					if(!giochi.contains(ge)) {
						giochi.add(ge);
					}
				}
			}
			if(giochiByPiattaforma.size() != 0 && giochiByPiattaforma != null) {
				for(Gioco ge : giochiByPiattaforma) {
					if(!giochi.contains(ge)) {
						giochi.add(ge);
					}
				}
			}
			if(giochiBySviluppatore.size() != 0 && giochiBySviluppatore != null) {
				for(Gioco ge : giochiBySviluppatore) {
					if(!giochi.contains(ge)) {
						giochi.add(ge);
					}
				}
			}
			if(giochiByGenere.size() != 0 && giochiByGenere != null) {
				for(Gioco ge : giochiByGenere) {
					if(!giochi.contains(ge)) {
						giochi.add(ge);
					}
				}
			}
			System.out.println(giochi.toString()
					+ giochiByEditor.toString());
			model.addAttribute("giochi", giochi);
			redirect = "/gioco/AdminGiocoPage.html";
		}
		return redirect;
	}
}

