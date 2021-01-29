package com.example.SOTIS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Ucenik;
import com.example.SOTIS.repository.UcenikRepository;

@Service
public class UserService {

	@Autowired
	UcenikRepository ucenikRepo;

	public boolean addUcenik(Ucenik u) {
		try {
			ucenikRepo.save(u);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Long login(Ucenik ucenik) {
		Ucenik found = ucenikRepo.findByEmail(ucenik.getEmail());
		if (found == null) {
			return (long)0;
		}
		if (!found.getLozinka().equals(ucenik.getLozinka())) {
			return (long)0;
		}
		return found.getId();
	}
}
