package com.gevbagratunyan.school.entity.enums;

public enum Position {
    DIR("director"),
    DEP_DIR("deputy director"),
    ACC("accountant"),
    MGR("manager"),
    LIB("librarian"),
    SRV("service"),
    TEACHER("teacher"),
    OTHER("other");

    private String position;

    Position(String position){
        this.position=position;
    }

    @Override
    public String toString() {
        return position;
    }

    public static Position stringToEnum(String position){
        Position p;
        switch(position.toLowerCase()){
            case "director":
                p= Position.DIR;
                break;
            case "deputy director":
                p= Position.DEP_DIR;
                break;
            case "accountant":
                p= Position.ACC;
                break;
            case "manager":
                p= Position.MGR;
                break;
            case "librarian":
                p= Position.LIB;
                break;
            case "teacher":
                p= Position.TEACHER;
                break;
            case "service":
                p= Position.SRV;
                break;
            default: p= Position.OTHER;
        }
        return p;
    }
}
