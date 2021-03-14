package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.repository.EmployeeRepo;
import com.gevbagratunyan.school.service.SalaryManager;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    EmployeeRepo employeeRepo;
    SalaryManager salaryManager;

    public ManagerService(EmployeeRepo employeeRepo, SalaryManager salaryManager) {
        this.employeeRepo = employeeRepo;
        this.salaryManager = salaryManager;
    }

    public EmployeeResponse giveSalary(Long id, int workDays){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Employee not found"));
        double salary = salaryManager.calcSalary(employee,workDays);
        employee.getEmployeeBanking().addToBalance(salary);
        Employee savedEmployee = employeeRepo.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(savedEmployee, response);
        BeanUtils.copyProperties(savedEmployee.getEmployeeBanking(), response);
        response.setPosition(employee.getPosition().toString());
        response.setSpecialization(employee.getSpecialization().toString());
        return response;
    }

    public EmployeeResponse giveVacationSalary(Long id, int vacationDays){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Employee not found"));
        double salary = salaryManager.vacationSalary(employee,vacationDays);
        employee.getEmployeeBanking().addToBalance(salary);
        Employee savedEmployee = employeeRepo.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(savedEmployee, response);
        BeanUtils.copyProperties(savedEmployee.getEmployeeBanking(), response);
        response.setPosition(employee.getPosition().toString());
        response.setSpecialization(employee.getSpecialization().toString());
        return response;
    }

    public void nullAllBalances(){
        List<Employee> list = employeeRepo.findAll();
        for(Employee emp:list){
            emp.getEmployeeBanking().setBalance(0.0);
        }
        employeeRepo.saveAll(list);
    }

}
