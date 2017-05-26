package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Model of People
 * 
 * @author rafaelrph
 *
 */
@Entity
public class People {

	/**
	 * Id attribute
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * Name and email attributes
	 */
	private String name, email;

	/**
	 * Constructor without fields
	 */
	public People(){
		
	}
	
	/**
	 * Constructor with fields
	 * @param name
	 * @param email
	 */
	public People(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "[id: " + id + ", name: " + name + ", email: " + email + "]";
	}
	
}
