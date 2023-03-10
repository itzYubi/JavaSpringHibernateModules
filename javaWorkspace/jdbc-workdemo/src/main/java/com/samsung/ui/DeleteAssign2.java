package com.samsung.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAssign2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			sc = new Scanner(System.in);
		    int id;
		    System.out.println("Enter id to be deleted:");
			id = sc.nextInt();
			int rowsInserted=0;
			String sql = "DELETE FROM students WHERE id= ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rowsInserted= pst.executeUpdate();
			if (rowsInserted == 1)
				System.out.println("row deleted");
			else
				System.out.println("deletion error");
			
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