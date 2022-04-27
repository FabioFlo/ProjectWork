package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.entities.Genere;
import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.Piattaforma;
import com.g3.projectwork.entities.Sviluppatore;
import com.g3.projectwork.repos.EditorRepository;
import com.g3.projectwork.repos.GenereRepository;
import com.g3.projectwork.repos.GiocoRepository;
import com.g3.projectwork.repos.PiattaformaRepository;
import com.g3.projectwork.repos.SviluppatoreRepository;

@Controller
@RequestMapping(path = "/giochi")
public class GiocoAdminController {

	@Autowired
	private GiocoRepository giocoRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	@Autowired
	private SviluppatoreRepository sviluppatoreRepository;
	
	@Autowired
	private PiattaformaRepository piattaformaRepository;
	
	@Autowired
	private GenereRepository genereRepository;
	
	//SHOW PAGINA LISTA GIOCO
	@GetMapping("/listGioco")
	public String showGiocoList(Model model) {
		model.addAttribute("giochi", giocoRepository.findAll());
		return "gioco/AdminGiocoPage.html";
	}
	
	//SHOW PAGINA ADD GIOCO
	@GetMapping("/addGiocoPage")
	public String showAddGiocoPage(Model model) {
		model.addAttribute("gioco", new Gioco());
		model.addAttribute("piattaforme", piattaformaRepository.findAll());
		model.addAttribute("generi", genereRepository.findAll());
		model.addAttribute("sviluppatori", sviluppatoreRepository.findAll());
		model.addAttribute("editors", editorRepository.findAll());
		return "gioco/addGiocoPage.html";
	}
	
	//CREATE
	@PostMapping("/addGioco")
	public String addGioco(@Valid Gioco gioco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "gioco/addGiocoPage.html";
		}
		giocoRepository.save(gioco);
		return "gioco/AdminGiocoPage.html";
	}
	
	
	
	//SHOW PAGINA UPDATE GIOCO
	@GetMapping("/edit/{id}")
	public String showUpdateGioco(@PathVariable("id") Long id, Model model) {
		Gioco gioco = giocoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID" + id +" non valido"));
		model.addAttribute("gioco", gioco);
		model.addAttribute("piattaforme", piattaformaRepository.findAll());
		model.addAttribute("generi", genereRepository.findAll());
		model.addAttribute("sviluppatori", sviluppatoreRepository.findAll());
		model.addAttribute("editors", editorRepository.findAll());
		return "gioco/updateGiocoPage.html";
	}
	
	//UPDATE
	@PostMapping("/update/{id}")
	public String updateGioco(@PathVariable("id") Long id, @Valid Gioco gioco, BindingResult result, Model model) {
		if(result.hasErrors()) {
			gioco.setIDGioco(id);
			return "gioco/updateGiocoPage.html";
		}
		gioco.setIDGioco(id);
		giocoRepository.save(gioco);
		return "gioco/AdminGiocoPage.html";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String deleteGioco(@PathVariable("id") Long id, Model model) {
		Gioco gioco = giocoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
		giocoRepository.delete(gioco);
		return "gioco/AdminGiocoPage.html";
	}
	
	//NUOVO METODO UPDATE PROVA
		@RequestMapping(value ="/{id}/editor/{ideditor}/genere/{idgenere}/piattaforma/{idpiattaforma}/sviluppatore/{idsviluppatore}", method = RequestMethod.GET)
		public String assignGiocoToEditor(@PathVariable("id") Long idGioco,
								  @PathVariable("ideditor") Long idEditor,
								  @PathVariable("idgenere") Long idGenere,
								  @PathVariable("idpiattaforma") Long idPiattaforma,
								  @PathVariable("idsviluppatore") Long idsviluppatore) {
			Gioco gioco = giocoRepository.findById(idGioco).orElseThrow();
			Editor editor = editorRepository.findById(idEditor).orElseThrow();
			Genere genere = genereRepository.findById(idGenere).orElseThrow();
			Piattaforma piattaforma = piattaformaRepository.findById(idPiattaforma).orElseThrow();
			Sviluppatore sviluppatore = sviluppatoreRepository.findById(idsviluppatore).orElseThrow();
			gioco.setEditor(editor);
			gioco.setGenere(genere);
			gioco.setPiattaforma(piattaforma);
			gioco.setSviluppatore(sviluppatore);
			giocoRepository.save(gioco);
			return "gioco/RESULTUPDATE.html";
		}
}