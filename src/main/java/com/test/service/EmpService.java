package com.test.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.Employees;


@Service
@Repository
public class EmpService {
	
	private static Employees empData = new Employees();
	
	static
	{
		empData.getEmpList().add(new Employee(101, "Sahil", "Dell", "Blr"));
		empData.getEmpList().add(new Employee(102, "Devesh", "HCL", "Hyd"));
		empData.getEmpList().add(new Employee(103, "Saurav", "PWC", "Chn"));
		empData.getEmpList().add(new Employee(104, "Sajjan", "E Y", "Blr"));
		empData.getEmpList().add(new Employee(105, "Pramod", "Wabtec", "Blr"));
	}
	
	//add emp data
	public void addEmployee(Employee emp)
	{
		empData.getEmpList().add(emp);
	}
	
	//read emp data
	public Employees readEmployee()
	{
		return empData;
	}
	
	//update emp data
	public String updateEmployee(Employee emp)
	{
		for(int i = 0; i<empData.getEmpList().size(); i++)
		{
			Employee emp1 = empData.getEmpList().get(i);
			
			if(emp1.getId().equals(emp.getId()))
			{
				empData.getEmpList().set(i, emp);
			}
		}
		
		return "the given id is not available";
	}
	
	//delete emp data
	public String deletEmployee(Integer id)
	{
		for(int i = 0; i < empData.getEmpList().size(); i++)
		{
			Employee emp = empData.getEmpList().get(i);
			
			if(emp.getId().equals(id))
			{
				empData.getEmpList().remove(i);
			}
		}
		
		return "the given id is not available";
	}
}