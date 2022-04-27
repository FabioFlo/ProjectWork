package com.g3.projectwork.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.GiocoRatingKey;

public interface GiocoRatingRepository extends JpaRepository<GiocoRating, GiocoRatingKey>{
	
}
