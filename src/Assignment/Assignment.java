package src.Assignment;
import src.Calender;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Assignment {
    int priority;
    String name;
    String due_date;
    double hours;
    int weight;
    int year, month, day;
    int daysBetween;
    int day_of_week;

    public Assignment(String n, String d, int h, int w){
        name = n;
        due_date=d;
        hours=h;
        weight=w;
        daysBetween = (int)ChronoUnit.DAYS.between(LocalDate.now(),LocalDate.parse(due_date));
        year = Integer.valueOf(due_date.split("-")[0]);
        month = Integer.valueOf(due_date.split("-")[1]);
        day = Integer.valueOf(due_date.split("-")[2]);
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);
        day_of_week = date.get(Calendar.DAY_OF_WEEK);
        System.out.println(day_of_week);
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){return name;}
    public void setDue_date(String d){
        due_date=d;
    }
    public void setHours(double h){
        hours=h;
    }
    public void setWeight(int w){
        weight=w;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getWeight(){return weight;}
    public double getHours(){return hours;}
    public int getDaysBetween(){return daysBetween;}
    public void setDaysBetween(String current_date){
        LocalDate dateBefore = LocalDate.parse(current_date);
        LocalDate dateAfter = LocalDate.parse(due_date);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        System.out.println(noOfDaysBetween);
    }

}
