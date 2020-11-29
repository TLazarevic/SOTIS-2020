package com.example.SOTIS.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SOTIS.model.Odgovor;

public interface OdgovoriRepository extends JpaRepository<Odgovor, Long>{

	Set<Odgovor> findByPitanjeId(Long id);

}
