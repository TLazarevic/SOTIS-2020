package com.example.SOTIS.repository;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.SOTIS.model.Odgovor;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PitanjeDTO {

	/** @pdOid 8fa48bab-3db0-4639-b14e-41bbef66c068 */
	private long id;

	private String tekst;

	private Set<Odgovor> odgovori = new HashSet<>();;

	public PitanjeDTO() {
		super();
	}

	public PitanjeDTO(Pitanje p, Set<Odgovor> o) {
		this.id = p.getId();
		this.tekst = p.getTekst();
		this.odgovori = o;
	}

	public Set<Odgovor> getOdgovori() {
		return odgovori;
	}

	public void setOdgovori(Set<Odgovor> odgovori) {
		this.odgovori = odgovori;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

}
