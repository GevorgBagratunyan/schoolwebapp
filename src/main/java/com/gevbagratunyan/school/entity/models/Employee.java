package com.gevbagratunyan.school.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gevbagratunyan.school.entity.data.EmployeeBanking;
import com.gevbagratunyan.school.entity.enums.Position;
import com.gevbagratunyan.school.entity.enums.Specialization;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employees")
@JsonIgnoreProperties({"id", "employeeBanking" })
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ID_Card", nullable = false, unique = true)
    private String idCard;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "Email", unique = true)
    private String mail;

    @Column(name = "Created_Date", nullable = false)
    private Date createdDate;

    @Column(name = "Updated_Date")
    private Date updatedDate;

    @Column(name = "Position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "Specialization")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmployeeBanking employeeBanking;

}
