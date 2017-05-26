package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.People;

public class PeopleRepository extends BaseRepository {

	public PeopleRepository() {
		super();
	}
	
	public void create(People people){
		entityManager.getTransaction().begin();
		entityManager.persist(people);
		entityManager.getTransaction().commit();
	}
	
	public void update(People people){
		entityManager.getTransaction().begin();
		entityManager.merge(people);
		entityManager.getTransaction().commit();
	}
	
	public void delete(People people){
		entityManager.getTransaction().begin();
		entityManager.remove(people);
		entityManager.getTransaction().commit();
	}
	
	public List<People> findAll(){		
		return entityManager.createQuery("FROM People ORDER BY id", People.class).getResultList();
	}
	
	public People findById(Integer id){		
		return (People) entityManager.find(People.class, id);
	}
}
