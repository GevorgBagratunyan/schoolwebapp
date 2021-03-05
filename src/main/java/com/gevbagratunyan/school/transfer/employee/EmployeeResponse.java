package com.gevbagratunyan.school.transfer.employee;

import lombok.Data;

@Data
public class EmployeeResponse {
    
    private String name;
    private String idCard;
    private String mail;
    private String position;
    private String specialization;
    private int salary;
    private String bankCard;
    private int balance;
}
