package com.gevbagratunyan.school.transfer.admin.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AdminEmployeeBankingUpdateRequest {

    private int balance;
    @Min(value = 0, message = "Salary can not be negative")
    private int salary;
    @Size(min=15,max=15, message = "not valid card number")
    @Pattern(regexp = "^[0-9-]+$")
    private String bankCard;
}
