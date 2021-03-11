package com.gevbagratunyan.school.entity.enums;

public enum WeekDay {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String weekDay;

    WeekDay(String weekDay) {
        this.weekDay=weekDay;
    }

    @Override
    public String toString(){
        return  weekDay;
    }

    public WeekDay StringToEnum(String weekDay){
        WeekDay w;
        switch (weekDay.toLowerCase()){
            case "sunday":
                w=WeekDay.SUNDAY;
                break;
            case "monday":
                w=WeekDay.MONDAY;
                break;
            case "tuesday":
                w=WeekDay.TUESDAY;
                break;
            case "wednesday":
                w=WeekDay.WEDNESDAY;
                break;
            case "thursday":
                w=WeekDay.THURSDAY;
                break;
            case "friday":
                w=WeekDay.FRIDAY;
                break;
            case "saturday":
                w=WeekDay.SATURDAY;
                break;
            default: throw new IllegalArgumentException("Wrong day of week");
        }
        return w;
    }
}
