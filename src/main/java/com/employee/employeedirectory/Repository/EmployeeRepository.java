package com.employee.employeedirectory.Repository;

import com.employee.employeedirectory.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(String employeeId);
    void deleteByEmployeeId(String employeeId);
}