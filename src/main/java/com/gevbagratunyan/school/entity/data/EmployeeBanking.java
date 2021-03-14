package com.gevbagratunyan.school.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Finances")
public class EmployeeBanking {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Bank_Card_Number")
    private String bankCard;

    @Column(name = "Salary")
    private double salary;

    @Column(name = "Balance")
    private double balance;

    @Column(name = "Vacation_Start_Date")
    private LocalDate vacationStartDate;

    @Column(name = "Vacation_End_Date")
    private LocalDate vacationEndDate;

    @Column(name = "In_Vacation")
    private boolean inVacation = false;

    public double addToBalance(double money){
        return balance+=money;
    }
}
