package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository {

	EntityManagerFactory entityManagerFactory;
	
	EntityManager entityManager;
	
	public BaseRepository(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-hibernate-jpa");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
}
