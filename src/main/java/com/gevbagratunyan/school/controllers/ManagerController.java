package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.service.services.EmployeeService;
import com.gevbagratunyan.school.service.services.ManagerService;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import com.gevbagratunyan.school.transfer.manager.GiveSalaryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;
    private EmployeeService employeeService;

    public ManagerController(ManagerService managerService, EmployeeService employeeService) {
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @PutMapping("/salary/give-salary/{id}")
    public ResponseEntity<EmployeeResponse> giveSalary(@PathVariable Long id, @Valid @RequestBody GiveSalaryRequest salaryRequest){
        EmployeeResponse response = managerService.giveSalary(id, salaryRequest.getWorkDays());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/salary/give-vacation-salary/{id}")
    public ResponseEntity<EmployeeResponse> giveVacationSalary(@PathVariable Long id){
        EmployeeResponse response = managerService.giveVacationSalary(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/balance/null-all-balances")
    public ResponseEntity<Void> nullAllBalancesAfterTransfer(){
        managerService.nullAllBalances();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/send-to-vacation/{id}")
    public ResponseEntity<Void> sendToVacation(@PathVariable Long id){
        employeeService.setVacation(id, true);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/back-from-vacation/{id}")
    public ResponseEntity<Void> backFromVacation(@PathVariable Long id){
        employeeService.setVacation(id, false);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all-employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id){
        EmployeeResponse response = employeeService.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
