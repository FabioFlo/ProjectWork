package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.entities.Sviluppatore;

@Repository
public interface GiocoRepository extends JpaRepository<Gioco, Long>{
	
	public List<Gioco> findByIDGioco(Long IDGioco);
	
	public List<Gioco> findByTitolo(String titolo);
	
	@Query("select g from Gioco g where g.titolo like %?1%")
	List<Gioco> findByTitoloContaining(String titolo);

	public List<Gioco> findBySerie(String serie);
	
	public List<Gioco> findBySerieNotNull();
	
	public List<Gioco> findByPegi(int pegi);
	
	public List<Gioco> findByPiattaforma(Piattaforma piattaforma);
	
	@Query("select g from Gioco g left join fetch g.piattaforma p where p.nomePiattaforma like %?1%")
	List<Gioco> findByPiattaformaContaining(String nomePiattaforma);
	
	public List<Gioco> findByEditor(Editor editor);
	
	@Query("select g from Gioco g left join fetch g.editor e where e.nomeEditor like %?1%")
	List<Gioco> findByEditorContaining(String nomeEditor);
	
	public List<Gioco> findBySviluppatore(Sviluppatore sviluppatore);
	
	@Query("select g from Gioco g left join fetch g.sviluppatore s where s.nomeSviluppatore like %?1%")
	List<Gioco> findBySviluppatoreContaining(String nomeSviluppatore);
	
	public List<Gioco> findByGenere(Genere genere);
	
	@Query("select g from Gioco g left join fetch g.genere t where t.nomeGenere like %?1%")
	List<Gioco> findByGenereContaining(String nomeGenere);
}
