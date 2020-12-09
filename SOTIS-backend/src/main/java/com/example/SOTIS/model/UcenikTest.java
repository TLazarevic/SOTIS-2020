package com.example.SOTIS.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class UcenikTest {

	@EmbeddedId
	UcenikTestKey id;

	@ManyToOne
	@MapsId("ucenikId")
	@JoinColumn(name = "ucenik_id")
	Ucenik ucenik;

	@ManyToOne
	@MapsId("testId")
	@JoinColumn(name = "test_id")
	Test test;

	boolean uradjen;

	public UcenikTest() {
		super();
	}

	public UcenikTest(Ucenik student, Test course, boolean uradjen) {
		super();
		this.ucenik = student;
		this.test = course;
		this.uradjen = uradjen;
	}

	public UcenikTest(Ucenik student, Test course) {
		super();
		this.ucenik = student;
		this.test = course;
	}

	public UcenikTestKey getId() {
		return id;
	}

	public void setId(UcenikTestKey id) {
		this.id = id;
	}

	public Ucenik getStudent() {
		return ucenik;
	}

	public void setStudent(Ucenik student) {
		this.ucenik = student;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public boolean isUradjen() {
		return uradjen;
	}

	public void setUradjen(boolean uradjen) {
		this.uradjen = uradjen;
	}
	

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

}
