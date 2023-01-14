package src;
import java.util.*;
public class Calender {
    public static void main(String a[]) {
        String [][] calendar = new String[49][8];
        String [] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String [] times = {"12","1","2","3","4","5","6","7","8","9","10","11"};
        String [] thirtyMinInterval = {"00","30"};
        String [] ampm = {"am","pm"};

        ArrayList<String> timeConstructed = new ArrayList<String>();

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

        for (int i = 0; i < 2; i++) {
            for (String time : times) {
                timeConstructed.add(time + ":" + thirtyMinInterval[0] +ampm[i]);
                timeConstructed.add(time + ":" + thirtyMinInterval[1] +ampm[i]);
            }
        }

        int index = 1;
        for (String time: timeConstructed) {
            calendar[index][0] = time;
            index++;
        }

        for (String [] arr: calendar) {
            for (String element: arr) {
                System.out.print(element+"\t\t");
            }
            System.out.println("");
        }

    }
}


