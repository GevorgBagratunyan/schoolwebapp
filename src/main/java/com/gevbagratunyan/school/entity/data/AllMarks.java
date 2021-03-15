package com.gevbagratunyan.school.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Week_Marks")
@Data
public class AllMarks {

    @Id
    @GeneratedValue
    private Long id;


    @ElementCollection
    @CollectionTable(name = "Marks_Mathematics")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> MATH = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_English")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> ENG = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Russian_Lang")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> RUS = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Armenian_Lang")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> ARM = new HashMap();

    @ElementCollection
    @CollectionTable(name = "Marks_Chemistry")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> CHEM = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Physics")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> PHYS = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Geometry")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> GEOM = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Geography")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> GEOG = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Biology")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> BIOL = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_History")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> HIST = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Armenian_History")
    @MapKeyColumn(name = "Date")
    private Map<Timestamp,Double> ARM_HIST = new HashMap<>();
}
