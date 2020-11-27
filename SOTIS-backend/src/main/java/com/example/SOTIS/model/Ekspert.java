package com.example.SOTIS.model;

/***********************************************************************
 * Module:  Ekspert.java
 * Author:  Tash
 * Purpose: Defines the Class Ekspert
 ***********************************************************************/



/** @pdOid f27b0904-1c45-47d6-99a8-ec0ca16ad6b0 */
public class Ekspert {
	/** @pdOid b7143a2e-6a64-44ec-84f4-e73eb45323c6 */
	private long id;
	/** @pdOid b63e0b79-d802-42ba-bf16-11ad022f2d32 */
	private String name;
	/** @pdOid 7345648b-fb5f-4387-a22e-1524cb425034 */
	private String lastName;

	/**
	 * @pdRoleInfo migr=no name=ProstorZnanja assc=association6 mult=0..*
	 *             type=Aggregation
	 */
	public ProstorZnanja[] prostorZnanja;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ProstorZnanja[] getProstorZnanja() {
		return prostorZnanja;
	}

	public void setProstorZnanja(ProstorZnanja[] prostorZnanja) {
		this.prostorZnanja = prostorZnanja;
	}

}