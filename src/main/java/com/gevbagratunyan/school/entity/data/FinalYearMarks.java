package com.gevbagratunyan.school.entity.data;

import com.gevbagratunyan.school.entity.enums.Subject;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

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

    @Transient
    private Map<String, Double> marksList = new HashMap<>();

    public void setYearMark(Subject subject, Double mark){
        switch(subject){
            case MATH:
                MATH=mark;
                break;
            case ENG:
                ENG=mark;
                break;
            case RUS:
                RUS=mark;
                break;
            case ARM:
                ARM=mark;
                break;
            case CHEM:
                CHEM=mark;
                break;
            case PHYS:
                PHYS=mark;
                break;
            case GEOM:
                GEOM=mark;
                break;
            case GEOG:
                GEOG=mark;
                break;
            case BIOL:
                BIOL=mark;
                break;
            case HIST:
                HIST=mark;
                break;
            case ARM_HIST:
                ARM_HIST=mark;
                break;
            default: throw new  IllegalArgumentException();
        }
    }

    public Map<String,Double> initMarks(){
        marksList.put("Mathematics", MATH);
        marksList.put("English language", ENG);
        marksList.put("Russian language", RUS);
        marksList.put("Armenian language", ARM);
        marksList.put("Chemistry", CHEM);
        marksList.put("Physics", PHYS);
        marksList.put("Geometry", GEOM);
        marksList.put("Geography", GEOG);
        marksList.put("Biology", BIOL);
        marksList.put("History", HIST);
        marksList.put("Armenian History", ARM_HIST);
        return marksList;
    }
}
