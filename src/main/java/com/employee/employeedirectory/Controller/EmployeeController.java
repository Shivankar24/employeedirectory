package com.employee.employeedirectory.Controller;
import com.employee.employeedirectory.Entity.Employee;
import com.employee.employeedirectory.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("employee")
@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws Exception{
        return  new ResponseEntity(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping(value="getEmployeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId")String employeeId) throws Exception{
        return  new ResponseEntity(employeeService.findByEmployeeId(employeeId),HttpStatus.OK);
    }

    @GetMapping(value="getEmployeeById", consumes = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeByIds(@RequestBody List<Long> Ids) throws Exception{
        return  new ResponseEntity(employeeService.findByIdIn(Ids),HttpStatus.OK);
    }

    @GetMapping(value="getEmployeeByEmployeeId", consumes = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeByEmployeeIds(@RequestBody List<String> employeeIds) throws Exception{
        return  new ResponseEntity(employeeService.findByEmployeeIdIn(employeeIds),HttpStatus.OK);
    }

    @GetMapping(value="getEmployeeByDeptAndAddress/address={address}/dept={dept}", consumes = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeByEmployeeIds(@PathVariable("address")String address,
                                                                   @PathVariable("dept")String dept) throws Exception{
        return  new ResponseEntity(employeeService.findByDepartmentAndAddress(dept,address),HttpStatus.OK);
    }

    @PutMapping("updateEmployee")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee) throws Exception{
        return  new ResponseEntity(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping("deleteEmployeeById/{employeeId}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("employeeId") String employeeId) throws Exception{
        employeeService.deleteEmployee(employeeId);
        return  new ResponseEntity("Employee Deleted!",HttpStatus.OK);
    }
    @GetMapping("getAllEmployeesByPage/dept={dept}/page={pageNumber}/limit={limit}/sortBy={sortBy}")
    public ResponseEntity<Employee> getAllEmployeesByPage(@PathVariable("dept") String dept,
                                                          @PathVariable("pageNumber") int pageNumber,
                                                          @PathVariable("limit") int limit,
                                                          @PathVariable("sortBy") String sortBy) throws Exception{
        return  new ResponseEntity(employeeService.getAllEmployeesByPage(dept,pageNumber,limit,sortBy),HttpStatus.OK);
    }



}
