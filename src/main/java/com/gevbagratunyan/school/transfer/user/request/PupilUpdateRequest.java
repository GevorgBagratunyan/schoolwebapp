package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class PupilUpdateRequest {

    private String classname;
    @Email
    private String mail;
}
