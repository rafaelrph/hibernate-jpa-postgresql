package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Base Repository 
 * Instances the Entity Managers centralizing the database settings
 * 
 * @author rafaelrph
 *
 */
public class BaseRepository {

	/**
	 * Entity Manager Factory
	 */
	EntityManagerFactory entityManagerFactory;
	
	/**
	 * Entity Manager
	 */
	EntityManager entityManager;
	
	/**
	 * Constructor initializing the managers using the persistence(.xml)
	 */
	public BaseRepository(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-hibernate-jpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
}
