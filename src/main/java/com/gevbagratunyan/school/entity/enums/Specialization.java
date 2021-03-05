package com.gevbagratunyan.school.entity.enums;

public enum Specialization {
    ENG("english"),
    RUS("russian"),
    MATH("mathematics"),
    PHYS("physics"),
    GEOG("geography"),
    GEOM("geometry"),
    CHEM("chemistry"),
    NAT_HIST("national history"),
    ARM_HIST("armenian history"),
    LIT("literature"),
    GRAM("grammatical"),
    OTHER("other");

    private String specialization;

    Specialization(String specialization){
        this.specialization=specialization;
    }

    @Override
    public String toString() {
        return specialization;
    }

    public static Specialization stringToEnum(String sp){
        Specialization spec;
        switch(sp.toLowerCase()){
            case "english":
                spec= Specialization.ENG;
                break;
            case "russian":
                spec= Specialization.RUS;
                break;
            case "mathematics":
                spec= Specialization.MATH;
                break;
            case "physics":
                spec= Specialization.PHYS;
                break;
            case "geography":
                spec= Specialization.GEOG;
                break;
            case "geometry":
                spec= Specialization.GEOM;
                break;
            case "Chemistry":
                spec= Specialization.CHEM;
                break;
            case "national history":
                spec= Specialization.NAT_HIST;
                break;
            case "armenian history":
                spec= Specialization.ARM_HIST;
                break;
            case "literature":
                spec= Specialization.LIT;
                break;
            case "grammatical":
                spec= Specialization.GRAM;
                break;
            default: spec= Specialization.OTHER;
        }
        return spec;
    }
}
