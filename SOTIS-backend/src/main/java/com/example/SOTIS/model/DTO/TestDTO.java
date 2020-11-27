package com.example.SOTIS.model.DTO;

import com.example.SOTIS.model.Nastavnik;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.Predmet;
import com.example.SOTIS.model.Test;

public class TestDTO {

	private long id;

	public java.util.Collection<Pitanje> pitanje;

	public Predmet predmet;

	public Nastavnik nastavnik;
	
	public TestDTO(Test t, Nastavnik n) {
		this.id = t.getId();
		this.predmet = t.predmet;
		this.pitanje = t.pitanje;
		this.nastavnik = n;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Collection<Pitanje> getPitanje() {
		return pitanje;
	}

	public void setPitanje(java.util.Collection<Pitanje> pitanje) {
		this.pitanje = pitanje;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

}
