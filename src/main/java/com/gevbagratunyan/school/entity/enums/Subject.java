package com.gevbagratunyan.school.entity.enums;

public enum Subject {
    MATH("math"),
    ENG("eng"),
    RUS("rus"),
    ARM("arm"),
    CHEM("chem"),
    PHYS("phys"),
    GEOM("geom"),
    GEOG("geog"),
    BIOL("biol"),
    HIST("hist"),
    ARM_HIST("arm-hist");

    private String subject;

    Subject(String subject) {
        this.subject = subject;
    }

    public String getSubjectString() {
        return subject;
    }

    public static Subject stringToEnum(String subject){
        Subject s;
        switch (subject.toLowerCase()){
            case "math":
                s=Subject.MATH;
                break;
            case "eng":
                s=Subject.ENG;
                break;
            case "rus":
                s=Subject.RUS;
                break;
            case "arm":
                s=Subject.ARM;
                break;
            case "chem":
                s=Subject.CHEM;
                break;
            case "phys":
                s=Subject.PHYS;
                break;
            case "geom":
                s=Subject.GEOM;
                break;
            case "geog":
                s=Subject.GEOG;
                break;
            case "biol":
                s=Subject.BIOL;
                break;
            case "hist":
                s=Subject.HIST;
                break;
            case "arm-hist":
                s=Subject.ARM_HIST;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + subject.toLowerCase());
        }
        return s;
    }
}
