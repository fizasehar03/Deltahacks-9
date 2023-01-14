package src;
import java.util.*;
public class Calender {
    public static void main(String a[]) {
        String [][] calendar = new String[49][8];
        String [] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String [] times = {"12","1","2","3","4","5","6","7","8","9","10","11"};
        String [] thirtyMinInterval = {"00","30"};
        String [] ampm = {"am","pm"};

        for (String [] arr: calendar) {
            Arrays.fill(arr,"E");
        }

        for (int i = 0; i <= days.length; i++) {
            if (i == 0) {
                calendar[0][i] = "\t";
            } else {
                calendar[0][i] = days[i - 1];
            }
        }

        for (String [] arr: calendar) {
            for (String element: arr) {
                System.out.print(element+"\t\t");
            }
            System.out.println("");
        }

        /*
        System.out.print("\t\t");
        for (String day: days) {
            System.out.print(day+"\t\t");
            if(day == "SAT"){
                System.out.print("\n");
            }
        }

        for (int i = 0; i < 2; i++) {
            for (String time : times) {
                System.out.print(time + ":" + thirtyMinInterval[0] +ampm[i]+ "\n");
                System.out.print(time + ":" + thirtyMinInterval[1] +ampm[i]+ "\n");
            }
        }

         */
    }
}


