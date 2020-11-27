package com.example.SOTIS.model;
/***********************************************************************
 * Module:  Pitanje.java
 * Author:  Tamara and Dusan
 * Purpose: Defines the Class Pitanje
 ***********************************************************************/

import java.util.Iterator;

/** @pdOid ca9d29ef-a4f5-4bcf-9b64-ba4b4ea47657 */
public class Pitanje {
	/** @pdOid 8fa48bab-3db0-4639-b14e-41bbef66c068 */
	private long id;

	/**
	 * @pdRoleInfo migr=no name=Odgovor assc=association2 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Composition
	 */
	public java.util.Collection<Odgovor> odgovor;

	/** @pdGenerated default getter */
	public java.util.Collection<Odgovor> getOdgovor() {
		if (odgovor == null)
			odgovor = new java.util.HashSet<Odgovor>();
		return odgovor;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorOdgovor() {
		if (odgovor == null)
			odgovor = new java.util.HashSet<Odgovor>();
		return odgovor.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newOdgovor
	 */
	public void setOdgovor(java.util.Collection<Odgovor> newOdgovor) {
		removeAllOdgovor();
		for (Iterator<Odgovor> iter = newOdgovor.iterator(); iter.hasNext();)
			addOdgovor((Odgovor) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newOdgovor
	 */
	public void addOdgovor(Odgovor newOdgovor) {
		if (newOdgovor == null)
			return;
		if (this.odgovor == null)
			this.odgovor = new java.util.HashSet<Odgovor>();
		if (!this.odgovor.contains(newOdgovor))
			this.odgovor.add(newOdgovor);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldOdgovor
	 */
	public void removeOdgovor(Odgovor oldOdgovor) {
		if (oldOdgovor == null)
			return;
		if (this.odgovor != null)
			if (this.odgovor.contains(oldOdgovor))
				this.odgovor.remove(oldOdgovor);
	}

	/** @pdGenerated default removeAll */
	public void removeAllOdgovor() {
		if (odgovor != null)
			odgovor.clear();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}