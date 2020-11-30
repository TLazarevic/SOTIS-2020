package com.example.SOTIS.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Odgovor;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.Test;
import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.model.UcenikTest;
import com.example.SOTIS.model.DTO.PitanjeDTO;
import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.model.DTO.TestViewDTO;
import com.example.SOTIS.repository.OdgovoriRepository;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;
import com.example.SOTIS.repository.UcenikTestRepository;


@Service
public class TestService {

	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	@Autowired
	OdgovoriRepository odgovorRepo;
	
	@Autowired
	UcenikTestRepository ucenikTestRepo;

	public List<TestDTO> findAllByNastavnik(Long id) {
		return testRepo.findAllByNastavnik(id);
	}

	public List<TestDTO> findAllByUcenik(Long id) {
		System.out.println(ucenikTestRepo.findByUcenikId(id).size());
		return ucenikTestRepo.findByUcenikId(id);
	}

	public boolean submitTest(Long id, TestViewDTO test) {
		try {
			Ucenik ucenik = ucenikRepo.findById(id).get();
			Test originalTest = testRepo.findById(test.getId()).get();
			for (PitanjeDTO pit : test.getPitanje()) {
				for (Odgovor o: pit.getOdgovori()) {
					Pitanje newPitanje = new Pitanje(pit.getId(), pit.getTekst());
					o.setPitanje(newPitanje);
					odgovorRepo.save(o);
				}
				
			}
			UcenikTest ut = ucenikTestRepo.findByUcenikAndTest(ucenik,originalTest);
			ut.setUradjen(true);
			ucenikTestRepo.save(ut);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TestViewDTO findById(Long id) {
		try {
			Test t = testRepo.findById(id).get();
			TestViewDTO dto = new TestViewDTO(t);
			
			for (Pitanje p : t.pitanje) {
				Set<Odgovor> o = odgovorRepo.findByPitanjeId(p.getId());
				PitanjeDTO pit = new PitanjeDTO(p, o);
				dto.pitanje.add(pit);
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
