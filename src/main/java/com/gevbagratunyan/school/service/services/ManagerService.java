package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.repository.EmployeeRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    EmployeeRepo employeeRepo;

    public ManagerService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public void giveSalary(Long id, int salary){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Employee not found"));
        employee.getEmployeeBanking().addToBalance(salary);
    }

}
