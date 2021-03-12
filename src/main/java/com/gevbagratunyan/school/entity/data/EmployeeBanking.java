package com.gevbagratunyan.school.entity.data;

import lombok.Data;

import javax.persistence.*;

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

    public double addToBalance(double money){
        return balance+=money;
    }
}
