package com.example.SOTIS.model;

/***********************************************************************
 * Module:  Pitanje.java
 * Author:  Tamara and Dusan
 * Purpose: Defines the Class Pitanje
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/** @pdOid ca9d29ef-a4f5-4bcf-9b64-ba4b4ea47657 */
public class Pitanje {

	@Id
	/** @pdOid 8fa48bab-3db0-4639-b14e-41bbef66c068 */
	private long id;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "pitanje")
	/**
	 * @pdRoleInfo migr=no name=Odgovor assc=association2 coll=java.util.Set
	 *             impl=java.util.Set mult=0..* type=Composition
	 */
	public Set<Test> test;

	@Column
	private String tekst;

	public Set<Test> getTest() {
		return test;
	}

	public void setTest(Set<Test> test) {
		this.test = test;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pitanje [id=" + id + ", test=" + test + ", tekst=" + tekst + "]";
	}

}