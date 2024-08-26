package com.hitesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hitesh.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
