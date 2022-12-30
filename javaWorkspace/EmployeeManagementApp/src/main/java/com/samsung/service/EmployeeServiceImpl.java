package com.samsung.service;

import java.util.List;

import com.samsung.dao.EmployeeDAO;
import com.samsung.dao.EmployeeDAOImpl;
import com.samsung.exception.EmployeeException;
import com.samsung.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDAO;

	public EmployeeServiceImpl() {
		empDAO = new EmployeeDAOImpl();
	}

	public Employee add(Employee emp) throws EmployeeException {
		if(emp!=null)
		{
			empDAO.add(emp);
		}
		return emp;
	}

	public Employee update(Employee emp) throws EmployeeException {
		if(emp!=null) {
			empDAO.update(emp);
		}
		return emp;
	}

	public void remove(Integer Empid) throws EmployeeException {
		empDAO.remove(Empid);	
	}

	public List<Employee> listAll() throws EmployeeException {
		return empDAO.listAll();
	}

	public Employee getByEmpId(Integer Empid) throws EmployeeException {
		return empDAO.getByEmpId(Empid);
	}
     
}
