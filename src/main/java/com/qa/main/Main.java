package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		DatabaseConnector db = new DatabaseConnector();

		String action = "";
		action = getAction();

		try {
			do {
				switch (action) {
				case "create":
					System.out.println("Please enter the first name");
					String fname = scan.nextLine();
					System.out.println("Please enter the last name");
					String lname = scan.nextLine();
					db.createActor(fname, lname);
					break;
				case "read":
					db.readAllActors();
					break;
				case "update":
					System.out.println("Enter the id of the actor you want to edit");
					int editId = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter the first name");
					String newForename = scan.nextLine();
					System.out.println("Please enter the last name");
					String newLastname = scan.nextLine();
					db.updateActor(newForename, newLastname, editId);
					break;

				case "delete":
					System.out.println("Please enter the id of the actor you want to remove");
					int id = Integer.parseInt(scan.nextLine());
					db.deleteActor(id);
					break;
				default:
					System.out.println("Bruh");
				}
				action = getAction();
			} while (!action.equals("Exit"));
			System.out.println("End");
		} finally {
			scan.close();
			db.close();
		}

	}

	private static String getAction() {
		System.out.println("Please enter the CRUD operation you would like to perform:");
		return scan.nextLine();
	}

}
