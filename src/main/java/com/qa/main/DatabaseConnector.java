package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {

	private Connection conn;
	private Statement st;

	public DatabaseConnector() throws SQLException {
		conn = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER,
				DatabaseConfiguration.PASS);
		
	}

	public void createActor(String forename, String surname) throws SQLException {
		st.executeUpdate(String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
				forename, surname));
	}

	public void readAllActors() throws SQLException {
		String sql = "select * from actor";
		this.st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.println(String.format("%s %s", rs.getString("first_name"), rs.getString("last_name")));
		}
	}

	public void updateActor(String fname, String lname) throws SQLException {

		// Updates first name based on last name
		String sql = String.format("update actor set first_name = '%s' where last_name = '%s' ", fname, lname);
		st.executeUpdate(sql);



	}

	public void deleteActor(String fname, String lname) throws SQLException {
		st.executeLargeUpdate(
				String.format("delete from actor where `first_name` = '%s' and `last_name` = '%s'", fname, lname));
	}

}
