package com.example.SOTIS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.ProstorZnanja;
import com.example.SOTIS.model.DTO.VezaRepository;
import com.example.SOTIS.repository.CvorRepository;
import com.example.SOTIS.repository.ProstorZnanjaRepository;

@Service
public class ZnanjeService {
	
	@Autowired
	CvorRepository cvorRepo;
	
	@Autowired
	VezaRepository vezaRepo;
	
	@Autowired
	ProstorZnanjaRepository znanjeRepo;
	
	public List<ProstorZnanja>findAll() {
		return znanjeRepo.findAll();
	}
	
	public ProstorZnanja findById(Long id) {
		return znanjeRepo.findById(id).get();
	}
	
	public boolean newProstor(ProstorZnanja prostor) {
		try {
			prostor.setId(-1);
			this.znanjeRepo.save(prostor);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public List<ProstorZnanja> findByPredmetId(Long id) {
		return this.znanjeRepo.findByPredmetId(id);
	}

}
