//use this website: https://beginnersbook.com/2017/10/java-8-calculate-days-between-two-dates/#:~:text=To%20calculate%20the%20days%20between,temporal.
//

package src;


import com.sun.security.jgss.GSSUtil;
import src.Assignment.Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Instant;
import java.util.Date;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Schedule {

    public static void main(String[] args) {
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
            System.out.print("Please enter the due date (2023-01-24 23:59): ");
            due_date=s.next();
            System.out.print("Please enter the weight of assignment (0-100): ");
            weight=s.nextInt();
            System.out.print("Please enter the hours needed to complete: ");
            hours=s.nextInt();
            assignments.add(new Assignment(name, due_date, hours, weight));
            System.out.print("Please enter 1 if you have more assignments: ");
            next = s.nextInt();
        }while(next == 1);

    }
}










