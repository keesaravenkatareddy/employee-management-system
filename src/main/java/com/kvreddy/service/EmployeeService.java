package com.kvreddy.service;

import com.kvreddy.entity.Employee;
import com.kvreddy.model.EmployeeResponse;
import com.kvreddy.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<EmployeeResponse> getEmployee(){
       List<Employee> list = employeeRepository.findAll();
       List<EmployeeResponse> employeeResponseList = empolyeeResponseFromEntity(list);
        return employeeResponseList;
    }

    private List<EmployeeResponse> empolyeeResponseFromEntity(List<Employee> entityList) {
        /*List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee employee: entityList) {
            EmployeeResponse employeeResponse = EmployeeResponse.builder()
                    .empId(employee.getEmpId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .emailId(employee.getEmailId())
                    .build();
            employeeResponses.add(employeeResponse);
        }*/
        List<EmployeeResponse> employeeResponseList = entityList.stream()
                .map(entity -> EmployeeResponse.builder()
                        .empId(entity.getEmpId())
                        .firstName(entity.getFirstName())
                        .lastName(entity.getLastName())
                        .emailId(entity.getEmailId())
                        .build()
                ).toList();

        return employeeResponseList;
    }

    public Employee addEmployee(Employee employee){
       return employeeRepository.save(employee);
    }
}
