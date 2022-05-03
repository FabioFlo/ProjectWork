package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.entities.Gioco;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long>{

	public List<Editor> findByIDEditor(Long iDEditor);
	
	public List<Editor> findByNomeEditor(String nomeEditor);
	
	public List<Editor> findByNomeEditorContaining(String nomeEditor);
}
