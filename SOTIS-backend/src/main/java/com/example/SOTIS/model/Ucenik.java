package com.example.SOTIS.model;

import java.util.Iterator;

/** @pdOid a8444d5b-5cb7-4497-865b-0eb2abb0682d */
public class Ucenik {
	/** @pdOid 09de1032-caf4-47b1-9ee1-586656fbb2d2 */
	private long id;
	/** @pdOid 0959a844-ca2b-42ba-b6d6-756bdcffe819 */
	private String name;
	/** @pdOid ce10ec1b-51a0-48cf-ae50-72d9f042f277 */
	private String lastName;

	/**
	 * @pdRoleInfo migr=no name=Test assc=association4 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	public java.util.List<Test> test;
	/**
	 * @pdRoleInfo migr=no name=ProstorZnanja assc=association5 mult=0..*
	 *             type=Composition
	 */
	public ProstorZnanja[] prostorZnanja;

	/** @pdGenerated default getter */
	public java.util.Collection<Test> getTest() {
		if (test == null)
			test = new java.util.ArrayList<Test>();
		return test;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTest() {
		if (test == null)
			test = new java.util.ArrayList<Test>();
		return test.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTest
	 */
	public void setTest(java.util.Collection<Test> newTest) {
		removeAllTest();
		for (Iterator<Test> iter = newTest.iterator(); iter.hasNext();)
			addTest((Test) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTest
	 */
	public void addTest(Test newTest) {
		if (newTest == null)
			return;
		if (this.test == null)
			this.test = new java.util.ArrayList<Test>();
		if (!this.test.contains(newTest))
			this.test.add(newTest);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTest
	 */
	public void removeTest(Test oldTest) {
		if (oldTest == null)
			return;
		if (this.test != null)
			if (this.test.contains(oldTest))
				this.test.remove(oldTest);
	}

	/** @pdGenerated default removeAll */
	public void removeAllTest() {
		if (test != null)
			test.clear();
	}

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