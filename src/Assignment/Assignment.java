package src.Assignment;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Assignment {
    String name;
    String due_date;
    int hours;
    int weight;
    int year, month, day;
    int days_between;

    public Assignment(String n, String d, int h, int w){
        name = n;
        due_date=d;
        hours=h;
        weight=w;
        year = Integer.valueOf(due_date.split("-")[0]);
        month = Integer.valueOf(due_date.split("-")[1]);
        day = Integer.valueOf(due_date.split("-")[2]);
    }

    public void setName(String n){
        name = n;
    }
    public void setDue_date(String d){
        due_date=d;
    }
    public void setHours(int h){
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
    public void setDaysBetween(String current_date){
        LocalDate dateBefore = LocalDate.parse(current_date);
        LocalDate dateAfter = LocalDate.parse(due_date);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        System.out.println(noOfDaysBetween);
    }

}
