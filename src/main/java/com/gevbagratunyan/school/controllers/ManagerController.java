package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.service.services.ManagerService;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import com.gevbagratunyan.school.transfer.manager.GiveSalaryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PutMapping("/salary/give-salary/{id}")
    public ResponseEntity<EmployeeResponse> giveSalary(@PathVariable Long id, @Valid @RequestBody GiveSalaryRequest salaryRequest){
        EmployeeResponse response = managerService.giveSalary(id, salaryRequest.getWorkDays());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/salary/give-vacation-salary/{id}")
    public ResponseEntity<EmployeeResponse> giveVacationSalary(@PathVariable Long id, @Valid @RequestBody GiveSalaryRequest salaryRequest){
        EmployeeResponse response = managerService.giveVacationSalary(id, salaryRequest.getWorkDays());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/balance/null-all-balances")
    public ResponseEntity<Void> nullAllBalancesAfterTransfer(){
        managerService.nullAllBalances();
        return ResponseEntity.ok().build();
    }

}
