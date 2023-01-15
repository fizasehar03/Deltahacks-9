package src;
import src.Assignment.Assignment;
import src.Schedule;

import java.util.ArrayList;

public class mainExecutable {
    public static void main(String [] args){
        Calender cal = new Calender();
        cal.block();
        ArrayList<Assignment> ass = cal.makeAssignment();
        //System.out.println(ass.get(0).getDaysBetween());
        cal.sortDueDates(ass);
        ArrayList<Assignment> assDay = cal.lessThanTwoDays(ass);
        cal.weightSort(assDay);
        for (Assignment a: assDay) {
            cal.priorityCreation(a);
        }


    }
}
