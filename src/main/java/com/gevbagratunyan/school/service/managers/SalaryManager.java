package com.gevbagratunyan.school.service.managers;


import com.gevbagratunyan.school.entity.models.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class SalaryManager {

    public double vacationSalary(Employee employee){
        Period diff = Period.between(employee.getEmployeeBanking().getVacationStartDate(), employee.getEmployeeBanking().getVacationEndDate());
        int vacationDays = diff.getDays();
        double taskedSalary = calcSalary(employee,vacationDays);
        double vacationSalary = (taskedSalary*80)/100;
        return vacationSalary;
    }

    //One month full working days equals 22
    public  double calcSalary(Employee employee, int workDays){
        double fullSalary = employee.getEmployeeBanking().getSalary();
        double salary = (fullSalary*workDays)/22;
        double taskedSalary;
        Period diff = Period.between(employee.getBirthDate(), LocalDate.now());
        int age = diff.getYears();

        if(salary>150000){
            taskedSalary = (salary*75)/100;
        } else {
            taskedSalary = (salary*80)/100;
        }

        if(age>25){
            taskedSalary = (taskedSalary*97.5)/100;
        }

        return taskedSalary;
    }
}
