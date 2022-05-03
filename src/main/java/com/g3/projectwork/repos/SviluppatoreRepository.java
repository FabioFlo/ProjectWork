package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.Sviluppatore;

@Repository
public interface SviluppatoreRepository extends JpaRepository<Sviluppatore, Long>{

	public List<Sviluppatore> findByIDSviluppatore(Long iDSviluppatore);
	
	public List<Sviluppatore> findByNomeSviluppatore(String nomeSviluppatore);
	
	public List<Sviluppatore> findByNomeSviluppatoreContaining(String nome);
}
