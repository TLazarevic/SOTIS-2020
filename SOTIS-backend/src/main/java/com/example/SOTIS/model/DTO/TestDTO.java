package com.example.SOTIS.model.DTO;

import com.example.SOTIS.model.Nastavnik;
import com.example.SOTIS.model.Pitanje;
import com.example.SOTIS.model.Predmet;

public class TestDTO {

	private long id;

	public java.util.Collection<Pitanje> pitanje;

	public Predmet predmet;

	public Nastavnik nastavnik;

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
