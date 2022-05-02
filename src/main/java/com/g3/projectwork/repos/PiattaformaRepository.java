package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.Piattaforma;

@Repository
public interface PiattaformaRepository extends JpaRepository<Piattaforma, Long>{

}
