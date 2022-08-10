package com.senseofcode.demo.jdbcdemo.entity;

import java.util.Date;

public class Person {
	private int id;
	private String name;
	private String location;
	private Date birthDate;
	public Person(int id,  String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", location=" + location + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
