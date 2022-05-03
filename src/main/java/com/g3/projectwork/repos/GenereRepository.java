package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.entities.Gioco;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Long>{

	public List<Genere> findByIDGenere(Long iDGenere);
	
	public List<Genere> findByNomeGenere(String nomeGenere);
	
	public List<Genere> findByNomeGenereContaining(String nomeGenere);
}