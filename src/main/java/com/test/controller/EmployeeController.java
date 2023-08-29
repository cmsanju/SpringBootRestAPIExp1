package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "EmployeeController for proccessing the user requests")
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	//read emp data
	@ApiOperation(value = "it will display employee data")
	@GetMapping(value = "/employees", produces = "application/json")
	public Employees getAllEmployees()
	{
		return empService.readEmployee();
	}
	
	//create emp data
	@ApiOperation(value = "it will add employee data")
	@PostMapping(value = "/createemp", consumes = "application/json")
	public Employees createEmployee(@RequestBody Employee emp )
	{
		Integer id = empService.readEmployee().getEmpList().size() + 1;
		
		emp.setId(id);
		
		empService.addEmployee(emp);
		
		return empService.readEmployee();
	}
	@ApiOperation(value = "it will update employee data")
	//update emp data
	@PutMapping(value = "/updateemp/{id}", consumes = "application/json")
	public Employees updateEmployee(@RequestBody Employee emp, @PathVariable("id") Integer id)
	{
		emp.setId(id);
		
		empService.updateEmployee(emp);
		
		return empService.readEmployee();
	}
	
	//delete emp data
	@ApiOperation(value = "it will delete employee data")
	@DeleteMapping(value = "/deleteemp/{id}", produces = "application/json")
	public Employees deleteEmployee(@PathVariable("id") Integer id)
	{
		empService.deletEmployee(id);
		
		return empService.readEmployee();
	}
}
