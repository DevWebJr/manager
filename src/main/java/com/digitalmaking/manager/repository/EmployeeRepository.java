package com.digitalmaking.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalmaking.manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);

}