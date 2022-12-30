package com.samsung.model;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer Empid;
	private String EmpName;
	private String EmpDept;
	private Integer Salary;
	
	public Employee() {
		
	}

	public Employee(Integer Empid, String EmpName, String EmpDept, Integer Salary) {
		this.Empid = Empid;
		this.EmpName = EmpName;
		this.EmpDept = EmpDept;
		this.Salary = Salary;
	}
	
	public Integer getEmpid() {
		return Empid;
	}
	public void setEmpid(Integer Empid) {
		this.Empid = Empid;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String EmpName) {
		this.EmpName = EmpName;
	}
	public String getEmpDept() {
		return EmpDept;
	}
	public void setEmpDept(String EmpDept) {
		this.EmpDept = EmpDept;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer Salary) {
		this.Salary = Salary;
	}

	@Override
	public String toString() {
		return "Employee [Empid=" + Empid + ", EmpName=" + EmpName + ", EmpDept=" + EmpDept + ", Salary=" + Salary
				+ "]";
	}
	
	

}
