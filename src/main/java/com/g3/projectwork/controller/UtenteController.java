package com.g3.projectwork.controller;

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
import com.g3.projectwork.repos.UtenteRepository;

// @RequestMapping(path = "api/utente")
// con questo path indichiamo l'accesso a l'API di utente

@RestController
@RequestMapping(path = "api/utente") 
public class UtenteController {

	// Richiamiamo l'interfaccia che utilizziamo per usufruire dei metodi crud
	private final UtenteRepository repository;
	
	// Amigos usa l'@Autowired anche qui ma non sono sicuro che sia necessario
	// In GiochiController non lo abbiamo usato per esempio
	@Autowired
	UtenteController(UtenteRepository repository) {
		this.repository = repository;
	}

	// List
	// metodo per la lista giochi
	@GetMapping("/utenti")
	Iterable<Utente> getUtenti() {
		return repository.findAll();
	}

	// Read Singolo
	// metodo per leggere un solo utente
	@GetMapping("/utente/{IDUtente}")
	Utente getUtente(@PathVariable Long IDUtente) {
		return repository.findById(IDUtente).orElseThrow();
	}

	// TODO: Rimane da gestire come passare il LocalDate.now() anche alla creazione
	// Create
	// metodo per creare un utente
	@PostMapping("/nuovoUtente")
	Utente createUtente(@RequestBody Utente newUtente) {
		return repository.save(newUtente);
	}

	// TODO: Il problema di lettura della data che risulta null anche qui 
	// Update
	// metodo per modificare l'utente
	@PutMapping("/modUtente/{IDUtente}")
	Utente updateUtente(@PathVariable Long IDUtente, @RequestBody Utente utenteDTO) {
		Utente u = repository.findById(IDUtente).orElseThrow();
		u.setBio(utenteDTO.getBio());
		u.setDataCompleanno(utenteDTO.getDataCompleanno());
		// in teoria questo dato non dovrebbe essere modificato in quanto autogenerato
		// al momento dlel'iscrizione LocalDate.now()
		// u.setDataIscrizione(utenteDTO.getDataIscrizione());
		u.setEmailAddress(utenteDTO.getEmailAddress());
		u.setPword(utenteDTO.getPword());
		u.setUserName(utenteDTO.getUserName());
		return repository.save(u);
	}

	
	
	// Delete
	// Elimina utente
	@DeleteMapping("/eliminaUtente/{IDUtente}")
	void deleteUtente(@PathVariable Long IDUtente) {
		Utente utente = repository.findById(IDUtente).orElseThrow();
		repository.delete(utente);
	}
	
	// esempio per testare il get
//	@GetMapping("/listaUtenti")
//	public List<Utente> getUtenti(){
//		return List.of(
//				new Utente(
//						1L,
//						"Dai",
//						"perfavore.funziona@gmail.com",
//						"1234",
//						"Bla"
//						+ "blabla"
//						+ "Lorem Ipsum"
//						+ "sit",
//						LocalDate.now(),
//						LocalDate.of(2000, 5, 10)
//						));
//	}
}
