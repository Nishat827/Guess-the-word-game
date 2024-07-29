package com.FetchAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FetchAPI.dao.Employee;
import com.FetchAPI.repository.Repository;

@Service
public class EmployeeService {
	
	@Autowired
	private Repository repo;
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> list = repo.findAll();
		return list;
	}
	
	public Employee getEmployeeById(int id) {
		
		Employee emp = repo.findById(id).get();
		return emp;
	}
	
	public Employee updateEmployeeById(Employee employee) {
		Employee employee2 = repo.findById(employee.getId()).get();
		if(employee2 != null) {
			employee2.setName(employee.getName());
			employee2.setAddress(employee.getAddress());
			employee2.setId(employee.getId());
		}
		
		return repo.save(employee2);
	}
	
	public String addEmployee(Employee employee) {
		repo.save(employee);
		return "Saved";
	}
	
	public String deleteEmployeeByiD(int id) {
		
		repo.deleteById(id);
		return "Employee deleted " + id;
	}

}
