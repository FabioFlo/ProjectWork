package com.g3.projectwork.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.model.EditorDTO;
import com.g3.projectwork.repos.EditorRepository;
import com.g3.projectwork.utility.GenericResponse;

@Service
public class EditorService {
	
	@Autowired
	private EditorRepository editorRepository;
	
	public List<EditorDTO> getEditori(){
		Iterable<Editor> editorList = editorRepository.findAll();
		List<EditorDTO> editorDTOList = new ArrayList<>();
		for(Editor editor : editorList) {
			EditorDTO editorDTO = new EditorDTO();
			editorDTO.setNomeEditor(editor.getNomeEditor());
			editorDTOList.add(editorDTO);
		}
		return editorDTOList;
	}
	
	public EditorDTO getEditor(Long IDEditor) {
		Editor editor = editorRepository.findById(IDEditor).orElseThrow();
		EditorDTO editorDTO = new EditorDTO();
		editorDTO.setNomeEditor(editor.getNomeEditor());
		return editorDTO;
	}
	
	public GenericResponse createEditor(EditorDTO editor) {
		Editor s = new Editor();
		s.setNomeEditor(editor.getNomeEditor());
		editorRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Editor creato correttamente");
		return response;
	}
	
	public GenericResponse updateEditor(Long IDEditor, EditorDTO editorDTO) {
		Editor s = editorRepository.findById(IDEditor).orElseThrow();
		s.setNomeEditor(editorDTO.getNomeEditor());
		editorRepository.save(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Editor modificato con successo");
		return response;
	}
	
	public GenericResponse deleteEditor(Long IDEditor) {
		Editor s = editorRepository.findById(IDEditor).orElseThrow();
		editorRepository.delete(s);
		GenericResponse response = new GenericResponse();
		response.setMessage("Editor eliminato correttamente");
		return response;
	}
}
