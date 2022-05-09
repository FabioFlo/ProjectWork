package com.g3.projectwork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.projectwork.entities.Gioco;
import com.g3.projectwork.entities.GiocoRating;
import com.g3.projectwork.entities.GiocoRatingKey;
import com.g3.projectwork.entities.Utente;
import com.g3.projectwork.repos.GiocoRatingRepository;

@Service
public class GiocoRatingService {
	@Autowired
	GiocoRatingRepository ratingRepository;
	
	public Iterable<GiocoRating> getAll(){
		return ratingRepository.findAll();
	}
	
	public List<GiocoRating> getByRating(double rating){
		return ratingRepository.findByRating(rating);
	}
	
	public Optional<GiocoRating> getByGiocoRatingKey(GiocoRatingKey giocoRatingKey){
		return ratingRepository.findById(giocoRatingKey);
	}
	
	public GiocoRating save(Utente utente, Gioco gioco, double rating, String reviewText) {
		GiocoRating g = GiocoRating.builder().build();
		g.setUtente(utente);
		g.setGioco(gioco);
		g.setRating(rating);
		g.setReviewText(reviewText);
		return ratingRepository.save(g);
	}
}
