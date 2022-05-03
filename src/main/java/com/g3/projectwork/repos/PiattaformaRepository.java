package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.Piattaforma;

@Repository
public interface PiattaformaRepository extends JpaRepository<Piattaforma, Long>{

	public List<Piattaforma> findByIDPiattaforma(Long iDPiattaforma);
	
	public List<Piattaforma> findByNomePiattaforma(String nomePiattaforma);
	
	public List<Piattaforma> findByNomePiattaformaContaining(String nomePiattaforma);
}
