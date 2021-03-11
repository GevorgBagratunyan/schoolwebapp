package com.gevbagratunyan.school.entity.data;

import com.gevbagratunyan.school.entity.enums.Subject;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
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
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> MATH = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_English")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> ENG = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Russian_Lang")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> RUS = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Armenian_Lang")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> ARM = new HashMap();

    @ElementCollection
    @CollectionTable(name = "Marks_Chemistry")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> CHEM = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Physics")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> PHYS = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Geometry")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> GEOM = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Geography")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> GEOG = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Biology")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> BIOL = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_History")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> HIST = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "Marks_Armenian_History")
    @MapKeyColumn(name = "Day_Of_Week")
    private Map<Timestamp,Double> ARM_HIST = new HashMap<>();

    public Double calculateAVG(Subject subject){
        Double b;
        switch (subject){
            case ARM:
                b=avg(this.ARM);
                break;
            case ENG:
                b=avg(this.ENG);
                break;
            case RUS:
                b=avg(this.RUS);
                break;
            case BIOL:
                b=avg(this.BIOL);
                break;
            case CHEM:
                b=avg(this.CHEM);
                break;
            case GEOG:
                b=avg(this.GEOG);
                break;
            case GEOM:
                b=avg(this.GEOM);
                break;
            case HIST:
                b=avg(this.HIST);
                break;
            case MATH:
                b=avg(this.MATH);
                break;
            case PHYS:
                b=avg(this.PHYS);
                break;
            case ARM_HIST:
                b=avg(this.ARM_HIST);
                break;
            default: b=0.0;
        }
        return b;
    }

    private Double avg(Map<Timestamp,Double> map){
        Double sum= 0.0;
        for(Map.Entry<Timestamp,Double> entry: map.entrySet()){
            sum=sum+ entry.getValue();
        }
        return sum/map.size();
    }

    public void setMark(Subject subject, Double mark){
        switch (subject){
            case ARM:
                this.ARM.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case ENG:
                this.ENG.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case RUS:
                this.RUS.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case BIOL:
                this.BIOL.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case CHEM:
                this.CHEM.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case GEOG:
                this.GEOG.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case GEOM:
                this.GEOM.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case HIST:
                this.HIST.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case MATH:
                this.MATH.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case PHYS:
                this.PHYS.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case ARM_HIST:
                this.ARM_HIST.put(new Timestamp(System.currentTimeMillis()),mark);
                break;
        }
    }
}
