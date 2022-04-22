package com.g3.projectwork.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.repos.EditorRepository;

@RestController
public class EditorController {
	
	private final EditorRepository editorRepository;
	
	EditorController(EditorRepository repository) {
		editorRepository = repository;
	}
	
	//lista editor
	@GetMapping("/editor")
	Iterable<Editor> getEditor(){
		return editorRepository.findAll();
	}
	
	//un editor
	@GetMapping("/editor/{IDEditor}")
	Editor getEditor(@PathVariable Long IDEditor) {
		return editorRepository.findById(IDEditor).orElseThrow();
	}
	
	//create editor
	@PostMapping("/editor")
	Editor createEditor(@RequestBody Editor newEditor) {
		return editorRepository.save(newEditor);
	}
	
	//update editor
	@PutMapping("/editor/{IDEditor}")
	Editor updateEditor(@PathVariable Long IDEditor, @RequestBody Editor editorDTO) {
	Editor editorDaAggiornare = editorRepository.findById(IDEditor).orElseThrow();
	editorDaAggiornare.setIDEditor(editorDTO.getIDEditor());
	editorDaAggiornare.setNomeEditor(editorDTO.getNomeEditor());
	return editorRepository.save(editorDaAggiornare);
	}
	
	//delete editor
	@DeleteMapping("/editor/{IDEditor}")
	void deleteEditor(@PathVariable Long IDEditor) {
		Editor editor = editorRepository.findById(IDEditor).orElseThrow();
		editorRepository.delete(editor);
	}
}
