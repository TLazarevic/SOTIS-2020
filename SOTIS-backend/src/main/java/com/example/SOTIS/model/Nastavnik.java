package com.example.SOTIS.model;

/***********************************************************************
 * Module:  Nastavnik.java
 * Author:  Tamara and Dusan
 * Purpose: Defines the Class Nastavnik
 ***********************************************************************/

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
/** @pdOid 185aebef-076c-48f3-aede-3d29dff41459 */
public class Nastavnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** @pdOid ce0768ab-aba1-4c10-944e-e608c6f8d31f */
	private long id;
	
	@Column
	/** @pdOid 84924235-ca8d-4674-819c-c2c057056afe */
	private String ime;
	
	@Column
	/** @pdOid ae58c1fd-e5b8-4efa-993a-7bbef9991cef */
	private String prezime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


}