package com.example.demo.app;

import java.util.List;
import java.util.Scanner;

import com.example.demo.dao.PeopleRepository;
import com.example.demo.model.People;

public class Application {

	private static PeopleRepository peopleRepository = new PeopleRepository();
	
	public static void main(String[] args) {
				
		try {
			
			Scanner input = new Scanner(System.in);
			int option;
			
			do {
				menu();
				option = Integer.parseInt(input.next());
				switch (option) {
					case 0:
						System.out.println("DONE!");
						break;
					case 1:
						create(readNew());
						break;
					case 2:
						listAll();
						break;
					case 3:
						findById(readObjectById());
						break;
					case 4:
						edit(readEdit());
						break;
					case 5:
						delete(readObjectById());
						break;
					case 6:
						insertMultiples(10000);
						break;
					default:
						System.out.println("Invalid option!");
						break;
				}
			} while(option != 0);
			
			
		} catch(Exception exc) {
			System.out.println("ERROR: " + exc.getMessage());
		}
		
	}
	
	public static void menu(){
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------");
		System.out.println(" ** MENU DE OPÇÕES **");
		System.out.println("--------------------------------------------------------------");
		System.out.println(" 1 - New");
		System.out.println(" 2 - List All");
		System.out.println(" 3 - Find by Id");
		System.out.println(" 4 - Edit");
		System.out.println(" 5 - Delete");
		System.out.println(" 6 - Insert Multiples");
		System.out.println("--------------------------------------------------------------");
		System.out.println(" 0 - EXIT");
		System.out.println("--------------------------------------------------------------");
		System.out.println("\n");
		System.out.print("Informe o Número da opção desejada: ");
	}
	
	public static People readNew(){
		System.out.println(" 1 - New");
		System.out.println("--------------------------------------------------------------");
		
		Scanner inputName = new Scanner(System.in);
		System.out.print("Name: ");
		String name = inputName.next();
		
		Scanner inputEmail = new Scanner(System.in);
		System.out.print("Email: ");
		String email = inputEmail.next();
		
		return new People(name, email);		
	}
	
	public static void create(People people){
		peopleRepository.create(people);
		System.out.println("OK - Created");
	}
	
	public static void listAll(){
		System.out.println(" 2 - List All");
		System.out.println("--------------------------------------------------------------");
		List<People> list = peopleRepository.findAll();
		for(People pe: list) {
			System.out.println(pe.toString());
		}
	}
	
	public static People readObjectById(){
		Scanner inputId = new Scanner(System.in);
		System.out.print("ID: ");
		int id = Integer.parseInt(inputId.next());
		
		return peopleRepository.findById(id);
	}
	
	public static void findById(People people){
		System.out.println(" 3 - Find by Id");
		System.out.println("--------------------------------------------------------------");
	
		if(people != null) {
			System.out.println(people.toString());
		} else {
			System.out.println("NOT FOUND");
		}
	}
	
	public static People readEdit(){
		System.out.println(" 4 - Edit");
		System.out.println("--------------------------------------------------------------");
		
		Scanner inputId = new Scanner(System.in);
		System.out.print("ID: ");
		int id = Integer.parseInt(inputId.next());
		
		Scanner inputName = new Scanner(System.in);
		System.out.print("Name: ");
		String name = inputName.next();
		
		Scanner inputEmail = new Scanner(System.in);
		System.out.print("Email: ");
		String email = inputEmail.next();
		
		People people = new People(name, email);
		people.setId(id);
		
		return people;		
	}
	
	public static void edit(People people) {
		peopleRepository.update(people);
		System.out.println("OK - Edited");
	}
	
	
	
	public static void delete(People people){
		System.out.println(" 5 - Delete");
		System.out.println("--------------------------------------------------------------");

		if(people != null) {
			peopleRepository.delete(people);
			System.out.println("OK - Removed");
		} else {
			System.out.println("NOT FOUND");
		}
	}
	
	public static void insertMultiples(int quantity){
		System.out.println("OK - Inserting...");
		long start = System.currentTimeMillis();
		for(int i = 1; i < quantity; i++) {
			People people = new People("People " + i, "mail" + i + "@mail.com");
			peopleRepository.create(people);
		}
		
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("DONE! Inserted " + quantity + " - In " + elapsed + " milliseconds");
	}
	
	

}
