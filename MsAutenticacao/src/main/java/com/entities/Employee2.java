package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;

	public Employee2(String username, String password){
		this.username = username;
		this.password = password;
	}

	public Employee2(int id, String username, String password){
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


}
