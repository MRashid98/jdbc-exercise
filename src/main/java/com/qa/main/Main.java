package com.qa.main;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		DatabaseConnector db = new DatabaseConnector();

		System.out.println("Printing initial database:");
		db.readAllActors();

		System.out.println("");
		
		System.out.println("Printing database after adding new actor:");
		db.createActor("Mohammad", "Rashid");
		db.readAllActors();

		System.out.println("");
		
		System.out.println("Printing database with modified actor:");
		db.updateActor("Azwad", "Rashid");
		db.readAllActors();

		System.out.println("");
		
		System.out.println("Printing database without newly added actor:");
		db.deleteActor("Azwad", "Rashid");
		db.readAllActors();

	}

}
