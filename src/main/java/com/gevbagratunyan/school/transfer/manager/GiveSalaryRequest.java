package com.gevbagratunyan.school.transfer.manager;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class GiveSalaryRequest {
    @NotEmpty
    @Min(value = 1, message = "minimum working days must be 1")
    @Max(value = 22, message = "maximum working days must be 22")
    private int workDays;
}
