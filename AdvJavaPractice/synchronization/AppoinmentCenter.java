package AdvJavaPractice.synchronization;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppoinmentCenter {

    private LocalDate day=LocalDate.now(); //19.12.2022

    public synchronized LocalDate getAppoinmentDate(){

        day=day.plusDays(1);

        return day;
    }

}
