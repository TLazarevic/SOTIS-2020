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
}
