package com.g3.projectwork.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.repos.GiocoRepository;
import com.g3.projectwork.utility.GestoreTemplate;


// Punto di riferimento per spring per gestire il servizio Rest
@RestController
public class GiocoController {

	private final GiocoRepository giocoRepository;
	
	//Percorso Locale views
	String percorsoCartellaViste = "D:\\Marco\\Marco - DRIVE\\JAITA50\\ProjectWork\\ProjectWork\\src\\main\\webapp\\";
	
	GestoreTemplate gestore = new GestoreTemplate(percorsoCartellaViste);
	
	GiocoController(GiocoRepository repository) {
		giocoRepository = repository;
	}
	
	//READ Lista giochi
    @GetMapping("/giochi")
    Iterable<Gioco> getGiochi(){
        return giocoRepository.findAll();
    }
 
	public List<Gioco> elencoGiochi() {
		List<Gioco> ris = new ArrayList<>();
		for(Gioco g : getGiochi()) {
			ris.add(g);
		}
		return ris;
	}
    
	@GetMapping("/elencoGiochi")
	public String getGioco() {
		getGiochi().iterator().hasNext();
		return gestore.graficaElenco(getGiochi());
	}
	
	
	
	
	
	//TODO
	//READ Singolo gioco
	@GetMapping("/giochi/{IDGioco}")
	Gioco getGiocoSingolo(@PathVariable Long IDGioco) {
		return giocoRepository.findById(IDGioco).orElseThrow();
	}
	
	
	//TODO
	//CREATE gioco
	@PostMapping("/giochi")
		Gioco createGioco(@RequestBody Gioco newGioco) {
		return giocoRepository.save(newGioco);
	}
	
	//TODO
	//UPDATE
	@PutMapping("/giochi/{IDGioco}")
	Gioco updateGioco(@PathVariable Long IDGioco, @RequestBody Gioco giocoDTO) {
		Gioco giocoDaAggiornare = giocoRepository.findById(IDGioco).orElseThrow();
		giocoDaAggiornare.setDataUscita(giocoDTO.getDataUscita());
		giocoDaAggiornare.setIDEditor(giocoDTO.getIDEditor());
		giocoDaAggiornare.setIDGenere(giocoDTO.getIDGenere());
		giocoDaAggiornare.setIDPiattaforma(giocoDTO.getIDPiattaforma());
		giocoDaAggiornare.setIDSviluppatore(giocoDTO.getIDSviluppatore());
		giocoDaAggiornare.setPegi(giocoDTO.getPegi());
		giocoDaAggiornare.setSerie(giocoDTO.getSerie());
		giocoDaAggiornare.setTitolo(giocoDTO.getTitolo());
		return giocoRepository.save(giocoDaAggiornare);
	}
	
	//TODO
	//DELETE
	@DeleteMapping("/giochi/{IDGioco}")
	void deletGioco(@PathVariable Long IDGioco) {
		Gioco gioco = giocoRepository.findById(IDGioco).orElseThrow();
		giocoRepository.delete(gioco);
	}
}
