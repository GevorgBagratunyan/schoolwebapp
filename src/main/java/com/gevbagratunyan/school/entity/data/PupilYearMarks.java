package com.gevbagratunyan.school.entity.data;

import com.gevbagratunyan.school.entity.enums.Subject;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class PupilYearMarks {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="ID_Card")
    private String idCard;

    private byte MATH;
    private byte ENG;
    private byte RUS;
    private byte ARM;
    private byte CHEM;
    private byte PHYS;
    private byte GEOM;
    private byte GEOG;
    private byte BIOL;
    private byte HIST;
    private byte ARM_HIST;

    @Transient
    private Map<String, Byte> marksList = new HashMap<>();

    public void setMark(Subject subject, byte mark){
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
        }
    }

    public Map<String,Byte> initMarks(){
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
