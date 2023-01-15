package src;
import java.util.*;

import java.io.*;
import java.util.Scanner;
import java.util.Calendar;


public class Calender {

    static HashMap<String,Integer> htTime;
    static HashMap<String,Integer> htDay;

    static void printCalendar(String [][] calendar){
        for (String [] arr: calendar) {
            for (String element: arr) {
                System.out.print(element+"\t\t");
            }
            System.out.println("");
        }
    }
    static void block(String[][] calendar){
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
            printCalendar(calendar);
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

    public static void main(String a[]) {
        String [][] calendar = new String[49][8];
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
        printCalendar(calendar);
        block(calendar);


        //System.out.println(htTime);
        //System.out.println(htTime.get("12:30am"));
        //System.out.println(htDay);
        //System.out.println(htDay.get("TUE"));
    }
}




