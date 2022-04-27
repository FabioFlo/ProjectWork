package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.entities.GiocoLatoUser;
import com.g3.projectwork.repos.EditorRepository;
import com.g3.projectwork.repos.GiocoLatoUserRepository;

@Controller
public class GiocoLatoUserController {

//	@Autowired
//	GiocoLatoUserRepository gluRepository;
//	
//	@Autowired
//	EditorRepository editorRepository;
//	
//	//Show All GLU
//	@GetMapping("/listGLU")
//	public String showGLUList(Model model) {
//		model.addAttribute("GLU", gluRepository.findAll());
//		return "AdminGLUPage.html";
//	}
//
//	//Show Pagina Add GLU - Diventerà il nostro punto d'appoggio per far lasciare un
//	//commento ad un utente
//	@GetMapping("/addGLUPage")
//	public String showAddGLUPage(Model model) {
//		model.addAttribute("GLU", new GiocoLatoUser());
//		return "addGLUPage.html";
//	}
//
//	//CREATE
//	@PostMapping("/addGLU")
//	public String addGLU(@Valid GiocoLatoUser glu, BindingResult result, Model model)
//	{
//		if(result.hasErrors()) {
//			return "addGLUPage.html";
//		}
//		gluRepository.save(glu);
//		return "AdminGLUPage.html";
//	}
//	
//	//SHOW PAGINA UPDATE -
//	//TODO: Aggiungere i valori dell'idUtente, Dell'idGioco e dell'idLista
//	
//	@GetMapping("/edit/{id}")
//	public String showUpdateForm(@PathVariable("id") long id, Model model) {
//		model.addAttribute("editors", editorRepository. )
//		Editor editor = gluRepository.findById(id)		
//				.orElseThrow(()-> new IllegalArgumentException("ID" + id +" non valido"));
//		model.addAttribute("editor", editor);
//		return "updateEditorPage.html";
//	}
//	
//	//UPDATE
//	@PostMapping("/update/{id}")
//	public String updateEditor(@PathVariable("id") long id, @Valid Editor editor, BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			editor.setIDEditor(id);
//			return "updateEditorPage.html";
//		}
//		editor.setIDEditor(id);
//		gluRepository.save(editor);
//		return "AdminEditorPage.html";			
//	}
//	//DELETE
//	@GetMapping("/delete/{id}")
//	public String deleteEditor(@PathVariable("id")long id, Model model) {
//		Editor editor = gluRepository.findById(id)
//				.orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
//		gluRepository.delete(editor);
//		return "AdminEditorPage.html";
//	}
}
