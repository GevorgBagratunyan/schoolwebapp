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

    @Column(name = "ID_Card", nullable = false)
    private String idCard;

    @Column(name = "Bank_Card_Number")
    private String bankCard;
    @Column(name = "Salary")
    private int salary;
    @Column(name = "Balance")
    private int balance;

}
