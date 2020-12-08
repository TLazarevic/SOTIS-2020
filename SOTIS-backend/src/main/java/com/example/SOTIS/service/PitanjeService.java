package com.example.SOTIS.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Odgovor;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.DTO.PitanjeDTO;
import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.repository.OdgovoriRepository;
import com.example.SOTIS.repository.PitanjeRepository;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;
import com.example.SOTIS.repository.UcenikTestRepository;

@Service
public class PitanjeService {

	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	@Autowired
	OdgovoriRepository odgovorRepo;
	
	@Autowired
	PitanjeRepository pitanjeRepo;
	
	public boolean dodajPitanje(PitanjeDTO pitanjeDTO) {
		
		Pitanje p = new Pitanje();
		p.setTekst(pitanjeDTO.getTekst());
		p.setPredmetId(pitanjeDTO.getPredmetId());
		//p.setPredmetId(pitanjeDTO.getPredmetId());
		pitanjeRepo.save(p);
		Set<Odgovor> odgovori = pitanjeDTO.getOdgovori();
		
		for(Odgovor odg : odgovori) {
			odg.setPitanje(p);
			odgovorRepo.save(odg);
		}
		
		return true;
	}
	
	public PitanjeDTO findById(Long id) {
		try {
			
			Pitanje p = pitanjeRepo.findById(id).get();
			
			Set<Odgovor> odgovori = odgovorRepo.findByPitanjeId(id);
			
			PitanjeDTO retPitanjeDTO = new PitanjeDTO();
			
			
			retPitanjeDTO.setTekst(p.getTekst());
			
			retPitanjeDTO.setOdgovori(odgovori);
			
			return retPitanjeDTO;
		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Pitanje> findAllByPredmet(Long id) {
		return pitanjeRepo.findByPredmet(id);
	}
	
	
}
