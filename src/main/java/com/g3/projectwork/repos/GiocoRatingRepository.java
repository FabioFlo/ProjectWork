package com.g3.projectwork.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.GiocoRatingKey;

@Repository
public interface GiocoRatingRepository extends JpaRepository<GiocoRating, GiocoRatingKey>{
	
	public List<GiocoRating> findByRating(double rating);
	
	
}
