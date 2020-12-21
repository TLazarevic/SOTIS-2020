package com.example.SOTIS.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/***********************************************************************
 * Module: Odgovor.java Author: Tamara and Dusan Purpose: Defines the Class
 * Odgovor
 ***********************************************************************/

@Entity
/** @pdOid fde4f205-5a55-45ef-afc3-68d1fe2ee0cc */
public class Odgovor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	/** @pdOid bd34634f-27ee-4c35-aba0-dd4bdb22183c */
	private String tekst;

	@Column(nullable = false)
	/** @pdOid 8ccea436-8bd7-4eb8-b146-d51b565d5641 */
	private boolean tacnost;

	@JsonIgnore
	@ManyToOne
	public Pitanje pitanje;

	@JsonIgnore
	@OneToOne
	public Ucenik ucenik;

	@Column(nullable = false)
	private int redniBr;

	public Pitanje getPitanje() {
		return pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
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

	public boolean isTacnost() {
		return tacnost;
	}

	public void setTacnost(boolean tacnost) {
		this.tacnost = tacnost;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public int getRedniBr() {
		return redniBr;
	}

	public void setRedniBr(int redniBr) {
		this.redniBr = redniBr;
	}

	@Override
	public String toString() {
		try {
			return "Odgovor [id=" + id + ", tekst=" + tekst + ", tacnost=" + tacnost + ", pitanje=" + pitanje.getId()
					+ ", ucenik=" + ucenik.getId() + ", redniBr=" + redniBr + "]";
		} catch (Exception e) {
			return " TACAN Odgovor [id=" + id + ", tekst=" + tekst + ", tacnost=" + tacnost + ", pitanje="
					+ pitanje.getId() + ", redniBr=" + redniBr + "]";
		}

	}

}