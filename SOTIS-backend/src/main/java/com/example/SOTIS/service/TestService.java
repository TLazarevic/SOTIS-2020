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
import com.example.SOTIS.model.DTO.TestDTO;
import com.example.SOTIS.model.DTO.TestViewDTO;
import com.example.SOTIS.repository.OdgovoriRepository;
import com.example.SOTIS.repository.PitanjeDTO;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	@Autowired
	OdgovoriRepository odgovorRepo;

	public List<TestDTO> findAllByNastavnik(Long id) {
		System.out.println(testRepo.findAllByNastavnik(id).size());
		return testRepo.findAllByNastavnik(id);
	}

	public List<TestDTO> findAllByUcenik(Long id) {
		return testRepo.findAllByUcenik(id);
	}

	public boolean submitTest(Long id, TestViewDTO test) {
		try {
//			Ucenik ucenik = ucenikRepo.findById(id).get();
//			Test originalTest = testRepo.findById(test.getId()).get();
//			ucenik.test.add(originalTest);
//			ucenikRepo.save(ucenik);
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
				System.out.println(p.getId());
				Set<Odgovor> o = odgovorRepo.findByPitanjeId(p.getId());
				System.out.println(o.size());
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
