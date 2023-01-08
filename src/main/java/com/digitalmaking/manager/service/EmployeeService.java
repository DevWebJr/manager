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

    /**
     * @param employeeRepository
     */
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * @param employee
     * @return
     */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    /**
     * @return
     */
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * @param employee
     * @return
     */
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * @param id
     * @return
     */
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findByEmployeeId(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    /**
     * @param id
     */
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}