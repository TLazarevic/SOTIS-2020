package com.example.SOTIS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/***********************************************************************
 * Module: Ekspert.java Author: Tash Purpose: Defines the Class Ekspert
 ***********************************************************************/

@Entity
/** @pdOid f27b0904-1c45-47d6-99a8-ec0ca16ad6b0 */
public class Ekspert extends Korisnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** @pdOid 09de1032-caf4-47b1-9ee1-586656fbb2d2 */
	private long id;

	@Column
	/** @pdOid 0959a844-ca2b-42ba-b6d6-756bdcffe819 */
	private String ime;

	@Column
	/** @pdOid ce10ec1b-51a0-48cf-ae50-72d9f042f277 */
	private String prezime;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String lozinka;

	/**
	 * @pdRoleInfo migr=no name=ProstorZnanja assc=association6 mult=0..*
	 *             type=Aggregation
	 */
	public ProstorZnanja[] prostorZnanja;

	public ProstorZnanja[] getProstorZnanja() {
		return prostorZnanja;
	}

	public void setProstorZnanja(ProstorZnanja[] prostorZnanja) {
		this.prostorZnanja = prostorZnanja;
	}

}