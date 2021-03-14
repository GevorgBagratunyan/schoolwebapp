package com.gevbagratunyan.school.entity.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FinalYearMarks {
    @Id
    @GeneratedValue
    private Long id;

    private Double MATH;
    private Double ENG;
    private Double RUS;
    private Double ARM;
    private Double CHEM;
    private Double PHYS;
    private Double GEOM;
    private Double GEOG;
    private Double BIOL;
    private Double HIST;
    private Double ARM_HIST;
}
