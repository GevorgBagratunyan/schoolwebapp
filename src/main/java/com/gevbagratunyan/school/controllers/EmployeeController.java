package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.service.services.EmployeeService;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import com.gevbagratunyan.school.transfer.user.request.EmployeeBankingUpdateRequest;
import com.gevbagratunyan.school.transfer.user.request.EmployeeCreateRequest;
import com.gevbagratunyan.school.transfer.user.request.EmployeeUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        return employeeService.get(id);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public EmployeeResponse createEmployee( @Valid @RequestBody EmployeeCreateRequest employeeCreateRequest) {
        return employeeService.add(employeeCreateRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateRequest updateRequest) {
        return employeeService.update(id,updateRequest);
    }

    @PutMapping("/banking/{id}")
    public EmployeeResponse updateBanking(@PathVariable Long id, @Valid @RequestBody EmployeeBankingUpdateRequest bankingUpdateRequest) {
        return employeeService.updateBanking(id, bankingUpdateRequest);
    }
}
