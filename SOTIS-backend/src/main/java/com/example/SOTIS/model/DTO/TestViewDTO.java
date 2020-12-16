package com.example.SOTIS.model.DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.SOTIS.model.Test;

public class TestViewDTO {

	private long id;

	public List<PitanjeDTO> pitanje = new ArrayList<>();

	public TestViewDTO() {
		super();
	}

	public TestViewDTO(Test t) {
		this.id = t.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<PitanjeDTO> getPitanje() {
		return pitanje;
	}

	public void setPitanje(List<PitanjeDTO> pitanje) {
		this.pitanje = pitanje;
	}

}
