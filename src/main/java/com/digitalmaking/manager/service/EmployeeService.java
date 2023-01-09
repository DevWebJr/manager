package com.digitalmaking.manager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.digitalmaking.manager.exception.UserNotFoundException;
import com.digitalmaking.manager.model.Employee;
import com.digitalmaking.manager.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " was not found."));
    }
    
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}