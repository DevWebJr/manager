package com.digitalmaking.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalmaking.manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(Long id);

    /**
     * @param id
     */
    void deleteEmployeeById(Long id);

}