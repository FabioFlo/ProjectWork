package com.g3.projectwork.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.projectwork.model.EditorDTO;
import com.g3.projectwork.services.EditorService;
import com.g3.projectwork.utility.GenericResponse;

@RestController
@RequestMapping(path = "api/editor")
public class EditorController {
	
	@Autowired
	private EditorService editorService;
	
	//lista Editor
	@GetMapping("/editor")
	private List<EditorDTO> getEditori(){
		return editorService.getEditori();
	}
	
	//uno Editor
	@GetMapping("/editor/{IDEditor}")
	private EditorDTO getEditor(@PathVariable Long IDEditor) {
		return editorService.getEditor(IDEditor);
	}
	
	//create Editor
	@PostMapping("/nuovoEditor")
	private GenericResponse createEditor(@RequestBody EditorDTO newEditor) {
		return editorService.createEditor(newEditor);
	}
	
	//update Editor
	@PutMapping("/editor/{IDEditor}")
	private GenericResponse updateEditor(@PathVariable Long IDEditor, @RequestBody EditorDTO editorDTO) {
		return editorService.updateEditor(IDEditor, editorDTO);
	}
	
	//delete Editor
	@DeleteMapping("/editor/{IDEditor}")
	private GenericResponse deleteEditor(@PathVariable Long IDEditor) {
		return editorService.deleteEditor(IDEditor);
	}
}