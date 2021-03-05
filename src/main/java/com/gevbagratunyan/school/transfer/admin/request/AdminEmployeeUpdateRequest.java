package com.gevbagratunyan.school.transfer.admin.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class AdminEmployeeUpdateRequest {

    @Email
    private String mail;
    private String position;
    private String specialization;
}

