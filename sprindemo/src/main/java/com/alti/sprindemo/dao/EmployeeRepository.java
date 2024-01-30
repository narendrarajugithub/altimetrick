package com.alti.sprindemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alti.sprindemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
