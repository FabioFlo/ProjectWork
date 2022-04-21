package com.g3.projectwork.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Utente;

@RestController
@RequestMapping(path = "api/utente")
public class UtenteController {

	@GetMapping("/listaUtenti")
	public List<Utente> getUtenti(){
		return List.of(
				new Utente(
						1L,
						"Dai",
						"perfavore.funziona@gmail.com",
						"1234",
						"Bla"
						+ "blabla"
						+ "Lorem Ipsum"
						+ "sit",
						LocalDate.now(),
						LocalDate.of(2000, 5, 10)
						));
	}
}
