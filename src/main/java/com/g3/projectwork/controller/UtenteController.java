package com.g3.projectwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Utente;
import com.g3.projectwork.model.GenericResponse;
import com.g3.projectwork.model.UtenteDTO;
import com.g3.projectwork.services.UtenteService;

// @RequestMapping(path = "api/utente")
// con questo path indichiamo l'accesso a l'API di utente

@RestController
@RequestMapping(path = "api/utente")
public class UtenteController {
	// Per convenzione nel controller non vengono eseguite operazioni o
	// orchestrazioni
	// ma deve essere richiamato un singolo metodo della classe UtenteService per
	// ogni metodo del controller.
	// La classe UtenteService funziona come una classe aggregatrice.
	// Di conseguenza non serve dichiarare qui UtenteRepository perchè tutte le
	// operazioni col database
	// vengono svolte nel service
	// NOTA BENE: i metodi di questa classe devono avere visibilità private per una
	// questione di sicurezza.
	// In input ai metodi post, non dovrà mai esserci la classe tuente ma la classe
	// UtenteDTO!
	// La classe UtenteDTO contiene gli stessi campi della classe @Entity Utente ma
	// senza le annotation dell'entity.
	// Questo perchè la classe di entity deve essere utilizzata solo per
	// interfacciarsi col database

	@Autowired
	private UtenteService utenteService;

	// List
	// metodo per la lista giochi
	@GetMapping("/utenti")
	private List<UtenteDTO> getUtenti() {
		return utenteService.getUtenti();
	}

	// Read Singolo
	// metodo per leggere un solo utente
	@GetMapping("/utente/{IDUtente}")
	private UtenteDTO getUtente(@PathVariable Long IDUtente) {
		return utenteService.getUtente(IDUtente);
	}

	// Create
	// metodo per creare un utente
	@PostMapping("/nuovoUtente")
	private GenericResponse createUtente(@RequestBody UtenteDTO newUtente) {
		return utenteService.createUtente(newUtente);
	}

	// funge
//	@PostMapping("/nuovoUtente")
//	Utente createUtente(@RequestParam ("bio") String bio,
//			@RequestParam("data_compleanno") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCompleanno,
//			@RequestParam ("email_address") String emailAddress,
//			@RequestParam ("pword") String pword,
//			@RequestParam ("user_name") String userName) {
//		LocalDate dataIscrizione = LocalDate.now();
//		Utente u = new Utente(userName, emailAddress, pword, bio, dataIscrizione, dataCompleanno);
//		return repository.save(u);
//	}
	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) questo signore dice al metodo che la data ha la formattazione (YYYY-MM-DD)

	// Update
	// metodo per modificare l'utente
	@PutMapping("/modUtente/{IDUtente}")
	private GenericResponse updateUtente(@PathVariable Long IDUtente, @RequestBody UtenteDTO utenteDTO) {
		return utenteService.updateUtente(IDUtente, utenteDTO);
	}

	// Delete
	// Elimina utente
	@DeleteMapping("/eliminaUtente/{IDUtente}")
	private GenericResponse deleteUtente(@PathVariable Long IDUtente) {
		return utenteService.deleteUtente(IDUtente);
	}

}
