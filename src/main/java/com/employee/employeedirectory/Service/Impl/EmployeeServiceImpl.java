package com.employee.employeedirectory.Service.Impl;

import com.employee.employeedirectory.Entity.Employee;
import com.employee.employeedirectory.Repository.EmployeeRepository;
import com.employee.employeedirectory.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee){
        employeeRepository.save(employee);
        return null;
    }

    @Override
    public Employee findByEmployeeId(String employeeId){
        Employee employee1 = employeeRepository.findByEmployeeId(employeeId);
        return employee1;
    }

    @Override
    @Transactional
    public void deleteEmployee(String employeeId){
        employeeRepository.deleteByEmployeeId(employeeId);

    }
    @Override
    public Employee updateEmployee(Employee employee){
        Employee employee1 = employeeRepository.findByEmployeeId(employee.getEmployeeId());
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setDepartment(employee.getDepartment());
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setAddress(employee.getAddress());
        employeeRepository.save(employee1);
        return employee1;
    }

}
