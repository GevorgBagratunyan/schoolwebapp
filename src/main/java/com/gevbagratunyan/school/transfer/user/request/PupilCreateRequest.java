package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class PupilCreateRequest {

    @NotEmpty
    @Size(min=10, max=10)
    private String idCard;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty
    private String classname;
    @NotEmpty
    @Email
    private String mail;
    @NotEmpty
    private String birthDate;

}
