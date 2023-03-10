package com.gyan.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gyan.bean.Employee;
import com.gyan.bean.EmployeePayslip;
import com.gyan.model.persistence.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public ArrayList<Employee> getAllEmployees(){
		return employeeDao.getAllRecords();
	}

	@Override
	public boolean insertEmployee(Employee employee){
		
		return employeeDao.insertData(employee);
	}

	@Override
	public boolean deleteEmployee(int empId){
		
		return employeeDao.deleteData(empId);
	}

	@Override
	public boolean updateSalary(int empId, int salary){
		return employeeDao.updateSalary(empId, salary);
	}

	@Override
	public Employee searchEmployee(int empId){
		return employeeDao.searchRecord(empId);
	}

	@Override
	public EmployeePayslip paySlip(int empId) {
		Employee employee=employeeDao.searchRecord(empId);
		EmployeePayslip employeePayslip=new EmployeePayslip();
		employeePayslip.setHra(.15*employee.getEmpSalary());
		employeePayslip.setDa(.08*employee.getEmpSalary());
		employeePayslip.setPf(.12*employee.getEmpSalary());
		employeePayslip.setTotalSalary(employee.getEmpSalary()+employeePayslip.getHra()+employeePayslip.getDa()-employeePayslip.getPf());
		employeePayslip.setEmployee(employee);
		return employeePayslip;
	}

}
