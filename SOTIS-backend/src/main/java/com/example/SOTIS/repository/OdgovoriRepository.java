package com.example.SOTIS.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SOTIS.model.Odgovor;

public interface OdgovoriRepository extends JpaRepository<Odgovor, Long> {

	Set<Odgovor> findByPitanjeId(Long id);

	Set<Odgovor> findByUcenikIdAndPitanjeId(Long ucId, Long pitId);

	@Query("SELECT o from Odgovor o WHERE o.ucenik=null and o.pitanje.id=?1")
	Set<Odgovor> findTacniOdgovori(Long pitId);

}
