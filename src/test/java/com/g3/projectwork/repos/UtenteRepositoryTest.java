package com.g3.projectwork.repos;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.GiocoRatingKey;
import com.g3.projectwork.entities.Utente;

@SpringBootTest
class UtenteRepositoryTest {
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Test
	public void saveUtente() {
		Utente utente = Utente.builder()
				.userName("Belnome")
				.emailAddress("qualcosa@gmail.com")
				.bio("Una bella bio")
				.pword("Pass")
				.dataIscrizione(LocalDate.now())
				.dataCompleanno(LocalDate.now())
				.build();
				;
				utenteRepository.save(utente);
	}
	
	@Test
	public void printAllUtente() {
		List<Utente> utenteList = utenteRepository.findAll();
		System.out.println(utenteList);
	}
}
