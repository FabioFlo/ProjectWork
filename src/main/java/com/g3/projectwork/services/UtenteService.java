package com.g3.projectwork.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Utente;
import com.g3.projectwork.model.UtenteDTO;
import com.g3.projectwork.repos.UtenteRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class UtenteService {
// In questa classe vengono effettuate le operazioni e le logiche dei metodi CRUD 
	// o di qualcunque altro metodo necessario nella classe UtenteController.
	// NOTA BENE: i metodi devono essere public per poter essere visibili e
	// richiamati nella classe UtenteController.
	@Autowired
	private UtenteRepository utenteRepository;

	// getUtenti non può restituire una lista di Entity (un entity non può mai
	// essere restituito in output)
	// Dal DB recupero una lista di Utente @Entity, la ciclo e popolo una lista di
	// UtenteDTO (DTO sta per Data Transefrt Objects)
	// che contiene gli stessi campi e può essere mandata in output
	// (è proprio lo scopo delle classi DTO essere usate in questi passaggi)
	public List<UtenteDTO> getUtenti() {
		Iterable<Utente> utenteList = utenteRepository.findAll();
		List<UtenteDTO> utenteDTOList = new ArrayList<>();
		for (Utente utente : utenteList) {
			UtenteDTO utenteDTO = new UtenteDTO();
			utenteDTO.setBio(utente.getBio());
			utenteDTO.setDataCompleanno(utente.getDataCompleanno());
			utenteDTO.setEmailAddress(utente.getEmailAddress());
			utenteDTO.setPword(utente.getPword());
			utenteDTO.setUserName(utente.getUserName());
			utenteDTO.setDataIscrizione(utente.getDataIscrizione());
			utenteDTOList.add(utenteDTO);
		}
		return utenteDTOList;
	}

	// In questo metodo viene fatta la stessa cosa del metodo getUtenti ma siccome
	// dobbiamo restituire un solo valore non è necessario ciclare.
	public UtenteDTO getUtente(Long IDUtente) {
		Utente utente = utenteRepository.findById(IDUtente).orElseThrow();
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setBio(utente.getBio());
		utenteDTO.setDataCompleanno(utente.getDataCompleanno());
		utenteDTO.setEmailAddress(utente.getEmailAddress());
		utenteDTO.setPword(utente.getPword());
		utenteDTO.setUserName(utente.getUserName());
		utenteDTO.setDataIscrizione(utente.getDataIscrizione());
		return utenteDTO;
	}

	public GenericResponse createUtente(UtenteDTO utente) {
		Utente u = new Utente();
		u.setBio(utente.getBio());
		u.setDataCompleanno(utente.getDataCompleanno());
		u.setEmailAddress(utente.getEmailAddress());
		u.setPword(utente.getPword());
		u.setUserName(utente.getUserName());
		u.setDataIscrizione(LocalDate.now());
		utenteRepository.save(u);
		GenericResponse response = new GenericResponse();
		response.setMessage("Utente creato correttamente");
		return response;
	}

	public GenericResponse updateUtente(Long IDUtente, UtenteDTO utenteDTO) {
		Utente u = utenteRepository.findById(IDUtente).orElseThrow();
		u.setBio(utenteDTO.getBio());
		u.setDataCompleanno(utenteDTO.getDataCompleanno());
		// in teoria questo dato non dovrebbe essere modificato in quanto autogenerato
		// al momento dell'iscrizione LocalDate.now()
		// u.setDataIscrizione(utenteDTO.getDataIscrizione());
		u.setEmailAddress(utenteDTO.getEmailAddress());
		u.setPword(utenteDTO.getPword());
		u.setUserName(utenteDTO.getUserName());
		utenteRepository.save(u);
		GenericResponse response = new GenericResponse();
		response.setMessage("Utente modificato correttamente");
		return response;
	}

	public GenericResponse deleteUtente( Long IDUtente) {
		Utente utente = utenteRepository.findById(IDUtente).orElseThrow();
		utenteRepository.delete(utente);
		GenericResponse response = new GenericResponse();
		response.setMessage("Utente eliminato correttamente");
		return response;
	}
}
