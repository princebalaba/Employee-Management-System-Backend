package com.princeCODEZ.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.princeCODEZ.entity.Employee;
import com.princeCODEZ.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
		//Get all Employees
		@GetMapping("/findAll")
	    public ResponseEntity<List<Employee>> getAllEmployee(){
	        List <Employee> employees = employeeService.findAll();
	        return  new ResponseEntity<>(employees, HttpStatus.OK);
	    }
		//Get Employee By Id
	    @GetMapping("/findEmployee/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
	        Employee employee = employeeService.findById(id);
	        //return  new ResponseEntity<>(employee, HttpStatus.OK);
	        //you can use either the return above Or below
	        return ResponseEntity.ok(employee);
	    }
	    //Create Employee
	    @PostMapping("/addEmployee")
	    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
	        Employee newEmployee = employeeService.saveEmployee(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }
	    //Update Employee
	    @PutMapping("/updateEmployee/{id}")
	    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") Long id,  @RequestBody Employee employee){
	        Employee updateEmployee = employeeService.update(employee, id);
	        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	    }
	    //Delete Employee
	    @DeleteMapping("/deleteEmployee/{id}")
	    public ResponseEntity<Map<String, Boolean>>deleteEmployee(@PathVariable("id") Long id) {
	         
	        //return new ResponseEntity<>(HttpStatus.OK);
	        return ResponseEntity.ok(employeeService.deleteEmployee(id));
	    }
	    
	    
	
	

}
