package com.gevbagratunyan.school.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gevbagratunyan.school.entity.data.AllMarks;
import com.gevbagratunyan.school.entity.data.FinalYearMarks;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@JsonIgnoreProperties({"id", "finalYearMarks","allMarks" })
public class Pupil {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="ID_Card")
    private String idCard;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Created_Date",nullable = false)
    private Date createdDate;

    @Column(name = "Updated_Date")
    private Date updatedDate;

    @Column(name = "eMail")
    private String mail;

    @Column(name="classRoom")
    private String classname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "yearmarks_id")
    private FinalYearMarks finalYearMarks;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "allmarks_id")
    private AllMarks allMarks;
}
