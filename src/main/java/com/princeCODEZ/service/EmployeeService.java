package com.princeCODEZ.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.princeCODEZ.entity.Employee;
import com.princeCODEZ.exception.ResourceNotFoundException;
import com.princeCODEZ.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
		
	}


	public List<Employee> findAll() {
		
		return employeeRepo.findAll();
	}


	public Employee findById(Long id) {
		
		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id : " + id));
	}

	/*
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
		
	}
	*/
	
	public Map<String, Boolean> deleteEmployee(Long id){
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id : " + id));
		employeeRepo.deleteById(id);
		Map<String , Boolean> response  = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return response;
		
	}
	

	
    public Employee update(Employee employeeDetails, Long id) {
		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id : " + id));
       
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
               
		Employee updatedEmployee = employeeRepo.save(employee);
		return updatedEmployee;
       
    }


/*	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp = employeeRepo.findById(id).get();
		//emp.setId(id);
		emp.setFName(emp.getFName());
		emp.setLName(emp.getLName());
		emp.setEmailId(emp.getEmailId());
		
		return employeeRepo.save(emp);
		
		
	}
	*/

}
