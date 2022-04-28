package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Genere;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Long>{

}
