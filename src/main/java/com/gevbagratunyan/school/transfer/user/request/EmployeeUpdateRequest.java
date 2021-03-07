package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class EmployeeUpdateRequest {

    @Email
    private String mail;
    private String position;
    private String specialization;
}

