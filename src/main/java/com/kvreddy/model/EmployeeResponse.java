package com.kvreddy.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeResponse {

    private long empId;
    private String firstName;
    private String lastName;
    private String emailId;


}
