package com.lti.model.beans;

public class User {
	private int id;
	private String name;
	private String phoneNumber;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String name, String phoneNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name2, String phoneNumber2, String password2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.phoneNumber = phoneNumber2;
		this.password = password2;
	}

}