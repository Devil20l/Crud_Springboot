package com.hitesh.service;

import java.util.List;

import com.hitesh.Entity.Employee;

public interface EmpService {

	public Employee save(Employee emp);

	public List<Employee> getAllEmp();

	public Employee getEmpById(int id);
	
	public boolean deleteEmp(int id);

}
