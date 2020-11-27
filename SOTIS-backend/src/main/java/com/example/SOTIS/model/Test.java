package com.example.SOTIS.model;
/***********************************************************************
 * Module:  Test.java
 * Author:  Tash
 * Purpose: Defines the Class Test
 ***********************************************************************/

import java.util.Iterator;

/** @pdOid b9e0a4d4-18b8-4c35-87c6-39374d7494f6 */
public class Test {
   /** @pdOid da220cbc-edb8-426f-8054-783e0ba641bf */
   private long id;
   
   /** @pdRoleInfo migr=no name=Pitanje assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Pitanje> pitanje;
   /** @pdRoleInfo migr=no name=Predmet assc=association8 mult=0..1 type=Aggregation */
   public Predmet predmet;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pitanje> getPitanje() {
      if (pitanje == null)
         pitanje = new java.util.HashSet<Pitanje>();
      return pitanje;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPitanje() {
      if (pitanje == null)
         pitanje = new java.util.HashSet<Pitanje>();
      return pitanje.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPitanje */
   public void setPitanje(java.util.Collection<Pitanje> newPitanje) {
      removeAllPitanje();
      for (Iterator<Pitanje> iter = newPitanje.iterator(); iter.hasNext();)
         addPitanje((Pitanje)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPitanje */
   public void addPitanje(Pitanje newPitanje) {
      if (newPitanje == null)
         return;
      if (this.pitanje == null)
         this.pitanje = new java.util.HashSet<Pitanje>();
      if (!this.pitanje.contains(newPitanje))
         this.pitanje.add(newPitanje);
   }
   
   /** @pdGenerated default remove
     * @param oldPitanje */
   public void removePitanje(Pitanje oldPitanje) {
      if (oldPitanje == null)
         return;
      if (this.pitanje != null)
         if (this.pitanje.contains(oldPitanje))
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