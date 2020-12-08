package com.example.SOTIS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Predmet;
import com.example.SOTIS.repository.PredmetRepository;

@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmetRepo;
	
	public List<Predmet> getAllPredmeti(){
		return predmetRepo.findAll();
	}
}
