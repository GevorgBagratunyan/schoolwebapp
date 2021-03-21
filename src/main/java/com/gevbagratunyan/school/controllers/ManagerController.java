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

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/manager")
public class ManagerController {

    private ManagerService managerService;
    private EmployeeService employeeService;

    public ManagerController(ManagerService managerService, EmployeeService employeeService) {
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @PutMapping("/give-salary/{id}")
    public EmployeeResponse giveSalary(@PathVariable Long id, @Valid @RequestBody GiveSalaryRequest salaryRequest){
        return managerService.giveSalary(id, salaryRequest.getWorkDays());
    }

    @PutMapping("/give-vacation-salary/{id}")
    public ResponseEntity<EmployeeResponse> giveVacationSalary(@PathVariable Long id){
        EmployeeResponse response = managerService.giveVacationSalary(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/null-all-balances")
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

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id){
        return employeeService.get(id);
    }

}
