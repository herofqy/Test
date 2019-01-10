package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	
	private char gender;
	
	private Date birthday;
	
	private String profile;
	
	public User() {}
		
	public User(String name) {
		this.name=name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", profile=" + profile + "]";
	}
	
}
