package com.gevbagratunyan.school.service.managers;

import com.gevbagratunyan.school.entity.data.AllMarks;
import com.gevbagratunyan.school.entity.data.FinalYearMarks;
import com.gevbagratunyan.school.entity.enums.Subject;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class MarksManager {

    public Double calcYearMark(AllMarks allMarks, Subject subject){
        Double b;
        switch (subject){
            case ARM:
                b=avg(allMarks.getARM());
                break;
            case ENG:
                b=avg(allMarks.getENG());
                break;
            case RUS:
                b=avg(allMarks.getRUS());
                break;
            case BIOL:
                b=avg(allMarks.getBIOL());
                break;
            case CHEM:
                b=avg(allMarks.getCHEM());
                break;
            case GEOG:
                b=avg(allMarks.getGEOG());
                break;
            case GEOM:
                b=avg(allMarks.getGEOM());
                break;
            case HIST:
                b=avg(allMarks.getHIST());
                break;
            case MATH:
                b=avg(allMarks.getMATH());
                break;
            case PHYS:
                b=avg(allMarks.getPHYS());
                break;
            case ARM_HIST:
                b=avg(allMarks.getARM_HIST());
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

    public void initMark(AllMarks allMarks,Subject subject, Double mark){
        switch (subject){
            case ARM:
                allMarks.getARM().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case ENG:
                allMarks.getENG().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case RUS:
                allMarks.getRUS().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case BIOL:
                allMarks.getBIOL().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case CHEM:
                allMarks.getCHEM().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case GEOG:
                allMarks.getGEOG().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case GEOM:
                allMarks.getGEOM().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case HIST:
                allMarks.getHIST().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case MATH:
                allMarks.getMATH().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case PHYS:
                allMarks.getPHYS().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
            case ARM_HIST:
                allMarks.getARM_HIST().put(new Timestamp(System.currentTimeMillis()),mark);
                break;
        }
    }

    public void initYearMark(FinalYearMarks yearMarks, Subject subject, Double mark){
        switch(subject){
            case MATH:
                yearMarks.setMATH(mark);
                break;
            case ENG:
                yearMarks.setENG(mark);
                break;
            case RUS:
                yearMarks.setRUS(mark);
                break;
            case ARM:
                yearMarks.setARM(mark);
                break;
            case CHEM:
                yearMarks.setCHEM(mark);
                break;
            case PHYS:
                yearMarks.setPHYS(mark);
                break;
            case GEOM:
                yearMarks.setGEOM(mark);
                break;
            case GEOG:
                yearMarks.setGEOG(mark);
                break;
            case BIOL:
                yearMarks.setBIOL(mark);
                break;
            case HIST:
                yearMarks.setHIST(mark);
                break;
            case ARM_HIST:
                yearMarks.setARM_HIST(mark);
                break;
            default: throw new  IllegalArgumentException();
        }
    }

    public void initAllYearMarks(FinalYearMarks yearMarks, AllMarks allMarks){
        yearMarks.setARM(calcYearMark(allMarks,Subject.ARM));
        yearMarks.setENG(calcYearMark(allMarks,Subject.ENG));
        yearMarks.setARM_HIST(calcYearMark(allMarks,Subject.ARM_HIST));
        yearMarks.setBIOL(calcYearMark(allMarks,Subject.BIOL));
        yearMarks.setGEOG(calcYearMark(allMarks,Subject.GEOG));
        yearMarks.setGEOM(calcYearMark(allMarks,Subject.GEOM));
        yearMarks.setCHEM(calcYearMark(allMarks,Subject.CHEM));
        yearMarks.setMATH(calcYearMark(allMarks,Subject.MATH));
        yearMarks.setRUS(calcYearMark(allMarks,Subject.RUS));
        yearMarks.setPHYS(calcYearMark(allMarks,Subject.PHYS));
        yearMarks.setHIST(calcYearMark(allMarks,Subject.HIST));
    }

}
