package com.gevbagratunyan.school.transfer.admin.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class AdminPupilUpdateRequest {

    private String classname;
    @Email
    private String mail;
}
