package com.FetchAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FetchAPI.dao.Employee;
import com.FetchAPI.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> list = service.getAllEmployee();		
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam int id) {
		Employee employee = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/updateById")
	public String updateEmployeeById(@RequestBody Employee employee) {
		service.updateEmployeeById(employee);
		
		return "Updated";
	}
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee) {
		service.addEmployee(employee);
		return "successufully added";
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deleteEmployeeByiD(@PathVariable int id) {
		
		service.deleteEmployeeByiD(id);
		return "deleted";
	}
	
	
	
}
