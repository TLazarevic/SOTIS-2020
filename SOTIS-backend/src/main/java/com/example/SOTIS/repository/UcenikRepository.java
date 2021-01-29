package com.example.SOTIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.Ucenik;

public interface UcenikRepository extends JpaRepository<Ucenik, Long> {

	Ucenik findByEmail(String email);

	Ucenik findByLozinka(String lozinka);

}
