package com.g3.projectwork.restcontroller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.repos.GiocoRepository;


// Punto di riferimento per spring per gestire il servizio Rest
@RestController
public class GiocoRestController {

	private final GiocoRepository giocoRepository;

	//Percorso Locale views
	
	//String percorsoCartellaViste = "D:\\Marco\\Marco - DRIVE\\JAITA50\\ProjectWork\\ProjectWork\\src\\main\\webapp\\";

	//GestoreTemplate gestore = new GestoreTemplate(percorsoCartellaViste);

	GiocoRestController(GiocoRepository repository) {
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

//	@GetMapping("/elencoGiochi")
//	public String getGioco() {
//		getGiochi().iterator().hasNext();
//		return gestore.graficaElenco(getGiochi());
//	}

	//READ Singolo gioco
	@GetMapping("/singoloGioco")
	Gioco getGiocoSingolo(@RequestParam("IDGioco") Long IDGioco) {
		return giocoRepository.findById(IDGioco).orElseThrow();
	}

	//CREATE gioco
//	@GetMapping("/creaGioco")
//	Gioco createGiocoNuovo( @RequestParam("titolo") String titolo,
//			@RequestParam("dataUscita") LocalDate dataUscita,
//			@RequestParam("IDSviluppatore") Long IDSviluppatore,
//			@RequestParam("IDEditor") Long IDEditor,
//			@RequestParam("IDGenere") Long IDGenere,
//			@RequestParam("IDPiattaforma") Long IDPiattaforma,
//			@RequestParam("pegi") int pegi,
//			@RequestParam("serie") String serie) {
//
//		Gioco giocoNuovo = new Gioco(titolo, dataUscita, serie, pegi, IDPiattaforma, IDGenere, IDSviluppatore, IDEditor);
//		System.out.println(true);
//		return giocoRepository.save(giocoNuovo);
//	}













//	//UPDATE
//	@GetMapping("/giocoDaAggiornare")
//	void updateGioco(@RequestParam("IDGioco") Long IDGioco) {
//		Gioco giocoDaAggiornare = giocoRepository.findById(IDGioco).orElseThrow();
//	}
//
//	//UPDATE
//	@GetMapping("/aggiornaGioco")
//	Gioco updateGioco(@PathVariable Long IDGioco, @RequestBody Gioco giocoDTO) {
//		Gioco giocoDaAggiornare = giocoRepository.findById(IDGioco).orElseThrow();
//		giocoDaAggiornare.setIDEditor(giocoDTO.getIDEditor());
//		giocoDaAggiornare.setIDGenere(giocoDTO.getIDGenere());
//		giocoDaAggiornare.setIDPiattaforma(giocoDTO.getIDPiattaforma());
//		giocoDaAggiornare.setIDSviluppatore(giocoDTO.getIDSviluppatore());
//		giocoDaAggiornare.setPegi(giocoDTO.getPegi());
//		giocoDaAggiornare.setSerie(giocoDTO.getSerie());
//		giocoDaAggiornare.setTitolo(giocoDTO.getTitolo());
//		return giocoRepository.save(giocoDaAggiornare);
//	}

	//UPDATE
	@GetMapping("/modGioco/{IDGioco}")
	Gioco updateGioco(@PathVariable Long IDGioco, @RequestBody Gioco giocoDTO) {
		Gioco g = giocoRepository.findById(IDGioco).orElseThrow();
		g.setTitolo(giocoDTO.getTitolo());
		g.setDataUscita(giocoDTO.getDataUscita());
		g.setSerie(giocoDTO.getSerie());
		g.setPegi(giocoDTO.getPegi());
		//g.setIDPiattaforma(giocoDTO.getIDPiattaforma());
		//g.setIDGenere(giocoDTO.getIDGenere());
		//g.setIDSviluppatore(giocoDTO.getIDSviluppatore());
		//g.setIDEditor(giocoDTO.getIDEditor());
		return giocoRepository.save(g);
	}
	// ---------------------------------------------------------------------------
	



	//DELETE
	@GetMapping("/eliminaGioco")
	void deleteGioco(@RequestParam("IDGioco") Long IDGioco) {
		Gioco gioco = giocoRepository.findById(IDGioco).orElseThrow();
		giocoRepository.delete(gioco);
	}
}
