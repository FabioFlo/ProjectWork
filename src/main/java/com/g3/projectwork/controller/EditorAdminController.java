package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.repos.EditorRepository;

@Controller
@RequestMapping(path ="/editor")
public class EditorAdminController {
	
	@Autowired
	private EditorRepository editorRepository;
	
	//SHOW PAGINA LISTA EDITOR
	@GetMapping("/listEditor")
	public String showEditorList(Model model) {
		model.addAttribute("editors", editorRepository.findAll());
		return "editor/AdminEditorPage.html";
	}
	//SHOW PAGINA ADD EDITOR
	@GetMapping("/addEditorPage")
	public String showAddEditorPage(Model model) {
		model.addAttribute("editor",new Editor());
		return "editor/addEditorPage.html";
	}
	
	//CREATE
	@PostMapping("/addEditor")
	public String addEditor(@Valid Editor editor, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "editor/addEditorPage.html";
		}
		editorRepository.save(editor);
		return "editor/AdminEditorPage.html";
	}
	//SHOW PAGINA UPDATE - 
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Editor editor = editorRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID " + id +" non valido"));
		model.addAttribute("editor", editor);
		return "editor/updateEditorPage.html";
	}
	//UPDATE
	@PostMapping("/update/{id}")
	public String updateEditor(@PathVariable("id") Long id, @Valid Editor editor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			editor.setIDEditor(id);
			return "editor/updateEditorPage.html";
		}
		editor.setIDEditor(id);
		editorRepository.save(editor);
		return "editor/AdminEditorPage.html";
	}
	//DELETE
	@GetMapping("/delete/{id}")
	public String deleteEditor(@PathVariable("id") Long id, Model model) {
		Editor editor = editorRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID " + id + "non valido"));
		editorRepository.delete(editor);
		return "editor/AdminEditorPage.html";
	}
}
