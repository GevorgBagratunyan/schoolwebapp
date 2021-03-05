package com.gevbagratunyan.school.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gevbagratunyan.school.entity.data.EmployeeBanking;
import com.gevbagratunyan.school.entity.enums.Position;
import com.gevbagratunyan.school.entity.enums.Specialization;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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
    @Column(name = "name")
    private String name;
    @Column(name = "Email")
    private String mail;
    @Column(name = "Created_Date")
    private Date createdDate;
    @Column(name = "Updated_Date")
    private Date updatedDate;
    @Column(name = "Position")
    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(name = "Specialization")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmployeeBanking employeeBanking;

}
