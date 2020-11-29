package com.example.SOTIS.model.DTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.SOTIS.model.Predmet;
import com.example.SOTIS.model.Test;

public class TestViewDTO {

	private long id;

	public Set<PitanjeDTO> pitanje = new HashSet<>();

	public TestViewDTO() {
		super();
	}

	public TestViewDTO(Test t) {
		this.id = t.getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<PitanjeDTO> getPitanje() {
		return pitanje;
	}

	public void setPitanje(Set<PitanjeDTO> pitanje) {
		this.pitanje = pitanje;
	}

}
