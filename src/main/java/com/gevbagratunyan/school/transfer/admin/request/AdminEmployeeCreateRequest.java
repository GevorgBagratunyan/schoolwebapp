package com.gevbagratunyan.school.transfer.admin.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class AdminEmployeeCreateRequest {

    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty
    @Email
    private String mail;
    @NotEmpty
    @Size(min=10, max=10)
    private String idCard;
    @NotEmpty
    private String position;
    private String specialization;
    @Min(value = 0)
    private int salary;
    @Size(min=15,max=15, message = "not valid card number")
    @Pattern(regexp = "^[0-9-]*$",message = "not valid card number")
    private String bankCard;
}
