package com.gyan.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gyan.bean.Employee;
import com.gyan.bean.EmployeePayslip;

public interface EmployeeService {

	ArrayList<Employee> getAllEmployees();
	boolean insertEmployee(Employee employee);
	boolean deleteEmployee(int empId);
	boolean updateSalary(int empId,int salary);
	Employee searchEmployee(int empId);
	EmployeePayslip paySlip(int empId);
}
