package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Gioco;

// Questa è un interfaccia di tipo generico "generics"
// CrudRepository<T,ID> T richiede un oggetto (T where T = Gioco) e ID il tipo usato per l'ID
@Repository
public interface GiocoRepository extends JpaRepository<Gioco, Long>{
	@Query("select g from Gioco g where g.titolo like %?1%")
	List<Gioco> findByTitoloContaining(String titolo);
	
	@Query("select g from Gioco g left join fetch g.editor e where e.nomeEditor like %?1%")
	List<Gioco> findByEditorContaining(String nomeEditor);
	
	@Query("select g from Gioco g left join fetch g.piattaforma p where p.nomePiattaforma like %?1%")
	List<Gioco> findByPiattaformaContaining(String nomePiattaforma);
	
	@Query("select g from Gioco g left join fetch g.sviluppatore s where s.nomeSviluppatore like %?1%")
	List<Gioco> findBySviluppatoreContaining(String nomeSviluppatore);
	
	@Query("select g from Gioco g left join fetch g.genere t where t.nomeGenere like %?1%")
	List<Gioco> findByGenereContaining(String nomeGenere);
}
