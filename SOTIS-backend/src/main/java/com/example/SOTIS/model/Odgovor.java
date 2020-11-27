package com.example.SOTIS.model;

/***********************************************************************
 * Module:  Odgovor.java
 * Author:  Tamara and Dusan
 * Purpose: Defines the Class Odgovor
 ***********************************************************************/



/** @pdOid fde4f205-5a55-45ef-afc3-68d1fe2ee0cc */
public class Odgovor {
	/** @pdOid baff2039-fee0-4139-aca6-4000a8a98302 */
	private long id;
	/** @pdOid bd34634f-27ee-4c35-aba0-dd4bdb22183c */
	private String tekst;
	/** @pdOid 8ccea436-8bd7-4eb8-b146-d51b565d5641 */
	private boolean tacnost;

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