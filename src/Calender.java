package src;

import src.Assignment.Assignment;
import src.Schedule;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;


public class Calender {

    String [][] calendar;


    static HashMap<String,Integer> htTime;
    static HashMap<String,Integer> htDay;


    void priorityCreation(Assignment assignByDay){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        String stringDate = sdf.format(new Date());
        String currDayStr = stringDate.toUpperCase();
        currDayStr = currDayStr.replace(".", "");
        int currDay = htDay.get(currDayStr);
        f1: for (int i = currDay; i <= assignByDay.getDaysBetween(); i++) {
            for (int j = 1; j < calendar.length-1; j++) {
                if(calendar[j][i] == "E" && calendar[j+1][i] == "E"){
                    if(assignByDay.getHours() <= 0){
                        break f1;
                    }else {
                        calendar[j][i] = assignByDay.getName();
                        assignByDay.setHours(assignByDay.getHours()-0.5);
                        if(j==47 && assignByDay.getHours() > 0){
                            calendar[j+1][i] = assignByDay.getName();
                            assignByDay.setHours(assignByDay.getHours()-0.5);
                            break;
                        }
                    }
                }
            }
        }
        printCalendar();
    }
    void weightSort(ArrayList<Assignment> assignments){
        for (int i =0; i<assignments.size()-1; i++) {
            for(int j = 0; j<assignments.size()-i-1; j++) {
                if (assignments.get(j).getWeight() < assignments.get(j+1).getWeight()) {
                    Assignment temp = assignments.get(j);
                    assignments.set(j, assignments.get(j + 1));
                    assignments.set(j + 1, temp);
                }
            }
        }
    }

    ArrayList<Assignment> lessThanTwoDays(ArrayList<Assignment> assignments){
        ArrayList<Assignment> assignByDay = new ArrayList<Assignment>();
        for (Assignment a: assignments) {
            if(a.getDaysBetween() <= 2){
                assignByDay.add(a);
            }else{
                break;
            }
        }
        return assignByDay;
    }

    void sortDueDates(ArrayList<Assignment> assignments){
        for (int i =0; i<assignments.size()-1; i++) {
            for(int j = 0; j<assignments.size()-i-1; j++) {
                if (assignments.get(j).getDaysBetween() > assignments.get(j+1).getDaysBetween()) {
                    Assignment temp = assignments.get(j);
                    assignments.set(j, assignments.get(j + 1));
                    assignments.set(j + 1, temp);
                }
            }
        }
        for (Assignment a: assignments) {
            System.out.println(a.getDaysBetween());
        }
    }

    void printCalendar(){
        for (String [] arr: calendar) {
            for (String element: arr) {
                System.out.print(element+"\t\t");
            }
            System.out.println("");
        }
    }
    public ArrayList<Assignment> makeAssignment() {
        Scanner s = new Scanner(System.in);
        ArrayList<Assignment> assignments = new ArrayList<>();
        String name, due_date;
        int weight, hours;
        int next;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        int i =0;

        do{
            System.out.print("Please enter the name of the assignment: ");
            name = s.next();
            System.out.print("Please enter the weight of assignment (0-100): ");
            weight=s.nextInt();
            System.out.print("Please enter the hours needed to complete: ");
            hours=s.nextInt();
            System.out.print("Please enter the due date (2023-01-24): ");
            due_date = s.next();
            assignments.add(new Assignment(name, due_date, hours, weight));
            System.out.print("Please enter 1 if you have more assignments: ");
            next = s.nextInt();
        }while(next == 1);
        return assignments;
    }
    void block(){
        Scanner sc = new Scanner(System.in);
        int continues = 1;
        ArrayList <String> dayString = new ArrayList<>();
        ArrayList<String> startString= new ArrayList<>();
        ArrayList<String> endString= new ArrayList<>();
        int blocks = 0;
        while(true) {
            System.out.println("What day would you like to place a block?");
            while (true) {
                String dayCheck = sc.next();
                if(!htDay.containsKey(dayCheck)){
                    System.out.println("Invalid day, please use the first three letters of the day in all caps to input a day");
                }else{
                    System.out.println("\nNOTE FOR TIMING: Please select a time between 12:00am and 11:30pm");
                    System.out.println("Format: xx:00/xx:30 am/pm (eg. 12:30am, 4:00pm)");
                    dayString.add(dayCheck);
                    break;
                }
            }
            while(true) {
                System.out.println("What time does this block start?");
                String startCheck = sc.next();
                if(!htTime.containsKey(startCheck)){
                    System.out.println("Invalid time, please try again");
                }else{
                    startString.add(startCheck);
                    break;
                }
            }
            while(true) {
                System.out.println("\nWhat time does this block end?");
                String endCheck = sc.next();
                if(!htTime.containsKey(endCheck)){
                    System.out.println("Invalid time, please try again.");
                } else if (htTime.get(startString.get(blocks)) > htTime.get(endCheck)) {
                    System.out.println("Can't select a time before the start time.");
                }else{
                    endString.add(endCheck);
                    break;
                }
            }
            block2(startString.get(blocks), endString.get(blocks), dayString.get(blocks), calendar);
            printCalendar();
            System.out.println("\nIf you would like to continue please input 1: ");
            if(sc.nextInt() != 1){
                break;
            }else{
                blocks++;
            }
        }
    }
    public static void block2(String startString, String endString, String dayString, String[][] calendar){
        int start = htTime.get(startString);
        int end = htTime.get(endString)+1;
        int day = htDay.get(dayString);
        for (int i = start; i < end; i++) {
            calendar[i][day] = "-";
        }
    }

    public Calender() {
        calendar = new String[49][8];
        //System.out.println(calendar.length);
        String [] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String [] times = {"12","1","2","3","4","5","6","7","8","9","10","11"};
        String [] thirtyMinInterval = {"00","30"};
        String [] ampm = {"am","pm"};

        ArrayList<String> timeConstructed = new ArrayList<String>();
        htDay = new HashMap<>();
        htTime = new HashMap<>();

        for (String [] arr: calendar) {
            Arrays.fill(arr,"E");
        }

        for (int i = 0; i <= days.length; i++) {
            if (i == 0) {
                calendar[0][i] = "\t";
            } else {
                calendar[0][i] = days[i - 1];
                htDay.put(days[i-1],i);
            }
        }

        int hashMaker = 1;
        for (int i = 0; i < 2; i++) {
            for (String time : times) {
                String key00 = time + ":" + thirtyMinInterval[0] + ampm[i];
                timeConstructed.add(key00);
                htTime.put(key00,hashMaker);
                hashMaker++;
                String key30 = time + ":" + thirtyMinInterval[1] +ampm[i];
                timeConstructed.add(key30);
                htTime.put(key30,hashMaker);
                hashMaker++;
            }
        }

        int index = 1;
        for (String time: timeConstructed) {
            calendar[index][0] = time;
            index++;
        }
        printCalendar();
    }
}




