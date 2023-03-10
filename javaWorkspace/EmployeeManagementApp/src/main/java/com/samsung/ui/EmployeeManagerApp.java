package com.samsung.ui;

import java.util.List;
import java.util.Scanner;

import com.samsung.exception.EmployeeException;
import com.samsung.model.Employee;
import com.samsung.service.EmployeeService;
import com.samsung.service.EmployeeServiceImpl;

public class EmployeeManagerApp {
	private static EmployeeService empService;
	private static Scanner sc;
	
	public static void main(String[] args)
	{
	    empService= new EmployeeServiceImpl();
	    sc= new Scanner(System.in);
	    EmployeeOperations choice= null;
	    while(choice!=EmployeeOperations.QUIT) {
	    	System.out.println("Choice\t\tMenu");
			for(EmployeeOperations opt : EmployeeOperations.values()) {
				System.out.println(opt.ordinal() + "\t\t" + opt);
	    }
		System.out.println("Enter Choice : ");
		int ch = sc.nextInt();
			
		if (ch >= 0 && ch < EmployeeOperations.values().length) {
			choice = EmployeeOperations.values()[ch];
				
			switch (choice) {
			case ADD : doAdd();
						   break;
			case UPDATE: doUpdate();
						   break;
			case DELETE: doDelete();
						   break;
			case DISPLAY: doDisplay();
			               break;
			case QUIT: System.out.println("Application Terminated");
							break;
			}
		}		
	    }
    }
	
	private static void doAdd() {
		Employee emp = new Employee();
		System.out.print("Enter Empid : ");
		emp.setEmpid(sc.nextInt());
		System.out.print("Enter EmpName : ");
		emp.setEmpName(sc.next());
		System.out.print("Enter EmpDept: ");
		emp.setEmpDept(sc.next());
		System.out.print("Enter Salary : ");
		emp.setSalary(sc.nextInt());
		try {
			empService.add(emp);
			System.out.println("employee added succesfully");
		} catch(EmployeeException excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	private static void doUpdate() {
		Employee emp = new Employee();
		System.out.print("Enter Empid to be modified: ");
		emp.setEmpid(sc.nextInt());
		System.out.print("Enter new EmpName : ");
		emp.setEmpName(sc.next());
		System.out.print("Enter new EmpDept: ");
		emp.setEmpDept(sc.next());
		System.out.print("Enter new Salary : ");
		emp.setSalary(sc.nextInt());
		try {
			empService.update(emp);
			System.out.println("employee added succesfully");
		} catch(EmployeeException excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	private static void doDisplay() {
		try {
			List<Employee> emps = empService.listAll();
			if (emps == null || emps.isEmpty()) {
				System.out.println("No employees found");
			} else {
				for(Employee emp : emps) {
					System.out.println(emp.getEmpid() + "\t" + emp.getEmpName() + "\t" + emp.getEmpDept() + "\t" + emp.getSalary());
				}
			}
		} catch(EmployeeException excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	private static void doDelete() {
		System.out.print("Enter empId to delete : ");
		int Empid = sc.nextInt();
		try {
			empService.remove(Empid);
			System.out.println("emp deleted!");
		} catch(EmployeeException excep) {
			System.err.println("Error: " + excep.getMessage());
		}
	}
	
	
	
}
