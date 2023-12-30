package com.employee.employeedirectory.Service;
import com.employee.employeedirectory.Entity.Employee;


public interface EmployeeService {

     Employee createEmployee(Employee employee);
     Employee updateEmployee(Employee employee);

     Employee findByEmployeeId(String employeeId);

     void deleteEmployee(String employeeId);

    }
