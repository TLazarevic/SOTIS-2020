package com.example.SOTIS.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/***********************************************************************
 * Module: Odgovor.java Author: Tamara and Dusan Purpose: Defines the Class
 * Odgovor
 ***********************************************************************/

@Entity
/** @pdOid fde4f205-5a55-45ef-afc3-68d1fe2ee0cc */
public class Odgovor {

	@Id
	/** @pdOid baff2039-fee0-4139-aca6-4000a8a98302 */
	private long id;

	@Column
	/** @pdOid bd34634f-27ee-4c35-aba0-dd4bdb22183c */
	private String tekst;

	@Column
	/** @pdOid 8ccea436-8bd7-4eb8-b146-d51b565d5641 */
	private boolean tacnost;

	@ManyToOne
	public Pitanje pitanje;

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

}