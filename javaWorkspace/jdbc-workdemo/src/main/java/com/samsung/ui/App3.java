package com.samsung.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App3 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			
			sc = new Scanner(System.in);
		    int n;
		    System.out.println("Enter value of n: ");
		    n=sc.nextInt();
		    int id[]=new int[n];
		    String name[]= new String[n];
		    int marks[]=new int[n];
			for(int i=0;i<n;++i)
			{
				id[i] = sc.nextInt();
				name[i] = sc.next();
				marks[i]= sc.nextInt();
			}
			
			
			String sql = "INSERT INTO students(id,name,marks) VALUES (?,?,?)";
			pst = con.prepareStatement(sql);
			int rowsInserted=0;
			for(int i=0;i<n;++i)
			{
				
				pst.setInt(1, id[i]);
				pst.setString(2, name[i]);
				pst.setInt(3, marks[i]);
				rowsInserted+= pst.executeUpdate();
			}
			
			if (rowsInserted == n)
				System.out.println("rows inserted");
			else
				System.out.println("insertion error");
			
			
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