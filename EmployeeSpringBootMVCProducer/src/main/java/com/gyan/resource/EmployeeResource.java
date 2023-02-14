package com.gyan.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gyan.bean.Employee;
import com.gyan.bean.EmployeePayslip;
import com.gyan.model.service.EmployeeService;

@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployeesResource(){
	    List<Employee> employees = employeeService.getAllEmployees();
	    return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/{eId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeResource(@PathVariable("eId") int empId){
		Employee employee = employeeService.searchEmployee(empId);
		if(employee == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> insertEmployeeResouce(@RequestBody Employee employee){
		if(employeeService.insertEmployee(employee))
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@DeleteMapping(path = "/employees/{eId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployeeResource(@PathVariable("eId") int empId){
		Employee employee = employeeService.searchEmployee(empId);
		if(employeeService.deleteEmployee(empId))
			return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/employees/{eId}/{sal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployeeResource(@PathVariable("eId") int empId, @PathVariable("sal") int salary){
		if(employeeService.updateSalary(empId,salary))
			return new ResponseEntity<Employee>(employeeService.searchEmployee(empId),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@GetMapping(path = "/employees/payslip/{eId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeePayslip> employeePaySlipResource(@PathVariable("eId") int empId){
		EmployeePayslip employeePaySlip = employeeService.paySlip(empId);
		if(employeePaySlip != null)
			return new ResponseEntity<EmployeePayslip>(employeePaySlip,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
