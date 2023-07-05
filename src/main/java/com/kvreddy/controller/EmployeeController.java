package com.kvreddy.controller;

import com.kvreddy.entity.Employee;
import com.kvreddy.model.EmployeeResponse;
import com.kvreddy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @GetMapping
    public List<EmployeeResponse> getEmployees(){
        List<EmployeeResponse> employees = employeeService.getEmployee();
        return employees;
    }
    @PostMapping
    public Employee saveEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }


}
