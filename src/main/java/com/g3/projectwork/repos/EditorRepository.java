package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long>{

}
