package com.samsung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samsung.exception.EmployeeException;
import com.samsung.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static final String INS_QRY  = "INSERT INTO Employees(Empid,EmpName,EmpDept,Salary) VALUES (?,?,?,?)";
	public static final String UPD_QRY = "UPDATE Employees SET EmpName = ?, EmpDept = ?, Salary = ? WHERE Empid = ?";
	public static final String DEL_QRY = "DELETE FROM Employees WHERE Empid = ?";
	public static final String SELECT_ALL_QRY = "SELECT Empid,EmpName,EmpDept,Salary FROM Employees";
	public static final String SELECT_BY_ID_QRY = "SELECT EmpName,EmpDept,Salary FROM Employees WHERE Empid = ?";

	public Employee add(Employee emp) throws EmployeeException {
		if(emp!=null) {
			try {
				Connection con= ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(INS_QRY);
				pst.setInt(1, emp.getEmpid());
				pst.setString(2, emp.getEmpName());
				pst.setString(3, emp.getEmpDept());
				pst.setInt(4, emp.getSalary());
				pst.executeUpdate();
			}catch(SQLException excep) {
				throw new EmployeeException("An Error occured while inserting the data. Please try again!");
			}
		}
		return emp;
	}

	public Employee update(Employee emp) throws EmployeeException {
		if(emp!=null) {
			try {
				Connection con= ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(UPD_QRY);
				pst.setString(1, emp.getEmpName());
				pst.setString(2, emp.getEmpDept());
				pst.setInt(3, emp.getSalary());
				pst.setInt(4, emp.getEmpid());
				pst.executeUpdate();
			}catch(SQLException excep) {
				throw new EmployeeException("Error while Updating the data. Please try again!");
			}
		}
		return emp;
	}

	public void remove(Integer Empid) throws EmployeeException {
			try {
				Connection con= ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_QRY);
				pst.setInt(1, Empid);
				pst.executeUpdate();
			}catch(SQLException excep) {
				throw new EmployeeException("An Error occured while deletion.");
			}
	}

	public List<Employee> listAll() throws EmployeeException {
		List<Employee> employees = new ArrayList<Employee>();
		try{
			Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY);
				ResultSet rs = pst.executeQuery();
				Employee emp = null;
				while (rs.next()) {
					emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					employees.add(emp);
				}
			}catch(SQLException excep) {
				throw new EmployeeException("Sorry! An error occurred while fetching data");
			}
		return employees;
	}

	public Employee getByEmpId(Integer Empid) throws EmployeeException {
		Employee emp = null;
		try{
			    Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QRY);
				pst.setInt(1, Empid);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				}
			}catch(SQLException excep) {
				throw new EmployeeException("An error occurred while fetching data of the employee");
			}
		return emp;
	}

}
