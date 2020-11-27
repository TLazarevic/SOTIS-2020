package com.example.SOTIS.model;

/***********************************************************************
 * Module:  Test.java
 * Author:  Tash
 * Purpose: Defines the Class Test
 ***********************************************************************/

import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
/** @pdOid b9e0a4d4-18b8-4c35-87c6-39374d7494f6 */
public class Test {

	@Id
	/** @pdOid da220cbc-edb8-426f-8054-783e0ba641bf */
	private long id;

	@ManyToMany
	@JoinTable(name = "test_pitanje", joinColumns = @JoinColumn(name = "test_id"), inverseJoinColumns = @JoinColumn(name = "pitanje_id"))
	/**
	 * @pdRoleInfo migr=no name=Pitanje assc=association1 coll=java.util.List
	 *             impl=java.util.HashSet mult=0..* type=Composition
	 */
	public Set<Pitanje> pitanje;

	@ManyToOne
	/**
	 * @pdRoleInfo migr=no name=Predmet assc=association8 mult=0..1 type=Aggregation
	 */
	public Predmet predmet;

	@ManyToOne
	public Nastavnik nastavnik;

	public Nastavnik getNastavik() {
		return nastavnik;
	}

	public void setNastavik(Nastavnik nastavik) {
		this.nastavnik = nastavik;
	}

	public void setPitanje(Set<Pitanje> pitanje) {
		this.pitanje = pitanje;
	}

	/** @pdGenerated default getter */
	public Set<Pitanje> getPitanje() {
		return pitanje;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorPitanje() {
		return pitanje.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newPitanje
	 */
	public void setPitanje(java.util.List<Pitanje> newPitanje) {
		removeAllPitanje();
		for (Iterator<Pitanje> iter = newPitanje.iterator(); iter.hasNext();)
			addPitanje((Pitanje) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newPitanje
	 */
	public void addPitanje(Pitanje newPitanje) {

		this.pitanje.add(newPitanje);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldPitanje
	 */
	public void removePitanje(Pitanje oldPitanje) {

		this.pitanje.remove(oldPitanje);
	}

	/** @pdGenerated default removeAll */
	public void removeAllPitanje() {
		if (pitanje != null)
			pitanje.clear();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

}