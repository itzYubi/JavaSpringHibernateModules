package com.samsung.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Updateassign1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			sc = new Scanner(System.in);
		    int id;
		    int marks;
		    System.out.println("Enter id and marks to be updated: ");
			id = sc.nextInt();
			marks= sc.nextInt();
			String sql = "UPDATE students SET marks=? WHERE id= ?";
			pst = con.prepareStatement(sql);
			int rowsInserted=0;
			pst.setInt(1, marks);
			pst.setInt(2, id);
			rowsInserted= pst.executeUpdate();
			if (rowsInserted == 1)
				System.out.println("row updated");
			else
				System.out.println("updation error");
			
			
		} catch(ClassNotFoundException excep) {
			System.out.println(excep.getMessage());
		} catch(SQLException excep) {
			System.out.println(excep.getMessage());
		} finally {
			sc.close();
			try {
				pst.close();
			} catch(SQLException excep) {
				System.out.println(excep.getMessage());
			}
			try {
				con.close();
			} catch(SQLException excep) {
				System.out.println(excep.getMessage());
			}
			
		}
 	}
}
