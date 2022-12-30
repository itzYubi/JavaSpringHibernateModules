package com.samsung.ui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App1 {

	public static void main(String[] args) {
		try {
			// step-1: register the drive class (optional from jdk1.8)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step-2: establish connection
			System.out.println("Control is here");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","root");
			System.out.println("connected");
		} catch (ClassNotFoundException excep) {
			System.out.println("could not load jdbc driver.");
		} catch (SQLException exc) {
			System.out.println(exc.getMessage());
			System.out.println("could not connect");
		}

	}

}
