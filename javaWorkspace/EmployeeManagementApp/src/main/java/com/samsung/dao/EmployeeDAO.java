package com.samsung.dao;

import java.util.List;

import com.samsung.exception.EmployeeException;
import com.samsung.model.Employee;

public interface EmployeeDAO {
	Employee add(Employee emp) throws EmployeeException;
    Employee update(Employee emp) throws EmployeeException;
    void remove(Integer Empid) throws EmployeeException;
    List<Employee> listAll() throws EmployeeException;
    Employee getByEmpId(Integer Empid) throws EmployeeException;
}
