package com.example.SOTIS.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/***********************************************************************
 * Module: Predmet.java Author: Tamara and Dusan Purpose: Defines the Class
 * Predmet
 ***********************************************************************/

@Entity
/** @pdOid 504d1e35-43bb-40db-b9db-8ec39a8f5555 */
public class Predmet {

	@Id
	/** @pdOid 54579e1c-d939-47ca-b481-e4cb69285da4 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	/** @pdOid ad754e5d-65e8-4044-94c4-29d7b089052f */
	private String naziv;

	@ManyToMany
	/**
	 * @pdRoleInfo migr=no name=Nastavnik assc=association7
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private Set<Nastavnik> nastavnik;

	@JsonIgnore
	@ManyToMany(mappedBy = "predmet")
	private Set<Ucenik> ucenik;

	@JsonIgnore
	@OneToOne(mappedBy = "predmet")
	private ProstorZnanja prostorZnanja;

	/** @pdGenerated default getter */
	public java.util.Collection<Nastavnik> getNastavnik() {

		return nastavnik;
	}

	/**
	 * @pdGenerated default add
	 * @param newNastavnik
	 */
	public void addNastavnik(Nastavnik newNastavnik) {

		this.nastavnik.add(newNastavnik);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNastavnik
	 */
	public void removeNastavnik(Nastavnik oldNastavnik) {

		this.nastavnik.remove(oldNastavnik);
	}

	/** @pdGenerated default removeAll */
	public void removeAllNastavnik() {

		nastavnik.clear();
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(Set<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}

	public void setNastavnik(Set<Nastavnik> nastavnik) {
		this.nastavnik = nastavnik;
	}

	public ProstorZnanja getProstorZnanja() {
		return prostorZnanja;
	}

	public void setProstorZnanja(ProstorZnanja prostorZnanja) {
		this.prostorZnanja = prostorZnanja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nastavnik == null) ? 0 : nastavnik.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((ucenik == null) ? 0 : ucenik.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (id != other.id)
			return false;
		if (nastavnik == null) {
			if (other.nastavnik != null)
				return false;
		} else if (!nastavnik.equals(other.nastavnik))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (ucenik == null) {
			if (other.ucenik != null)
				return false;
		} else if (!ucenik.equals(other.ucenik))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + "]";
	}

}