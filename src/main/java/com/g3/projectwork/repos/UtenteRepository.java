package com.g3.projectwork.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{

	public List<Utente> findByIDUtente(Long iDUtente);

	public List<Utente> findByUserName(String userName);
	
	public List<Utente> findByUserNameContaining(String name);
	
	public List<Utente> findByEmailAddress(String emailAddress);
	
	public List<Utente> findByEmailAddressContaining(String email);
	
	public List<Utente> findByDataCompleanno(LocalDate dataCompleanno);
	
	public List<Utente> findByDataIscrizione(LocalDate dataIscrizione);
}