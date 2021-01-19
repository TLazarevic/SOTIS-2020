package com.example.SOTIS.model.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.SOTIS.model.Pitanje;

public class NextQDTO {

	public Pitanje pitanje = new Pitanje();
	int tacnost = 0;
	Set<Pitanje> preostalapitanja = new HashSet<Pitanje>();
	private List<List<String>> kSpaces;
	private List<Double> probabs;
	private Double l;

	public NextQDTO() {

	}

	public Set<Pitanje> getPreostalaPitanja() {
		return preostalapitanja;
	}

	public void setPreostalaPitanja(Set<Pitanje> preostalaPitanja) {
		this.preostalapitanja = preostalaPitanja;
	}

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public int getTacnost() {
		return tacnost;
	}

	public void setTacnost(int tacnost) {
		this.tacnost = tacnost;
	}

	public Set<Pitanje> getPreostalapitanja() {
		return preostalapitanja;
	}

	public void setPreostalapitanja(Set<Pitanje> preostalapitanja) {
		this.preostalapitanja = preostalapitanja;
	}

	public List<List<String>> getkSpaces() {
		return kSpaces;
	}

	public void setkSpaces(List<List<String>> kSpaces) {
		this.kSpaces = kSpaces;
	}

	public List<Double> getProbabs() {
		return probabs;
	}

	public void setProbabs(List<Double> probabs) {
		this.probabs = probabs;
	}

	public Double getL() {
		return l;
	}

	public void setL(Double l) {
		this.l = l;
	}

}
