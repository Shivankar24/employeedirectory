package com.employee.employeedirectory.Service;
import com.employee.employeedirectory.Entity.Employee;

import java.util.List;


public interface EmployeeService {

     Employee createEmployee(Employee employee);
     Employee updateEmployee(Employee employee);

     Employee findByEmployeeId(String employeeId);

     void deleteEmployee(String employeeId);

    List<Employee> findByIdIn(List<Long> employeeIds);

    List<Employee> findByEmployeeIdIn(List<String> employeeIds);
}
