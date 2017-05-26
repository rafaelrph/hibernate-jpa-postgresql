package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.People;

/**
 * People Repository
 * Extends BaseRepository for use the same database settings
 * 
 * @author rafaelrph
 *
 */
public class PeopleRepository extends BaseRepository {

	/**
	 * Constructor
	 */
	public PeopleRepository() {
		super();
	}
	
	/**
	 * Create/save a new object
	 * 
	 * @param people
	 */
	public void create(People people){
		entityManager.getTransaction().begin();
		entityManager.persist(people);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Update an object
	 * 
	 * @param people
	 */
	public void update(People people){
		entityManager.getTransaction().begin();
		entityManager.merge(people);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Remove an object
	 * 
	 * @param people
	 */
	public void delete(People people){
		entityManager.getTransaction().begin();
		entityManager.remove(people);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Find all the objects
	 * 
	 * @return
	 */
	public List<People> findAll(){		
		return entityManager.createQuery("FROM People ORDER BY id", People.class).getResultList();
	}
	
	/**
	 * Find by id an object
	 * 
	 * @param id
	 * @return
	 */
	public People findById(Integer id){		
		return (People) entityManager.find(People.class, id);
	}
}
