package com.employee.employeedirectory.Repository;

import com.employee.employeedirectory.Entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    Employee findByEmployeeId(String employeeId);
    void deleteByEmployeeId(String employeeId);

    List<Employee> findByIdIn(List<Long> inventoryIdList);

    List<Employee> findByEmployeeIdIn(List<String> inventoryIdList);
    List<Employee> findByDepartmentAndAddress(String department,String address);

    List<Employee> findAllByDepartment(String department,Pageable pageable);
}