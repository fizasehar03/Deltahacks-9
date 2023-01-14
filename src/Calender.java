package src;
import java.util.*;


public class Calender {

    static HashMap<String,Integer> htTime;
    static HashMap<String,Integer> htDay;

    static void block(String[][] calendar){
        Scanner sc = new Scanner(System.in);

        System.out.println("What day would you like to place a block?");
        String dayString = sc.nextLine();
        System.out.println("\nWhat time does this block start?");
        String startString = sc.nextLine();
        System.out.println("\nWhat time does this block end?");
        String endString = sc.nextLine();

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

        block(calendar);

        for (String [] arr: calendar) {
            for (String element: arr) {
                System.out.print(element+"\t\t");
            }
            System.out.println("");
        }
        //System.out.println(htTime);
        //System.out.println(htTime.get("12:30am"));
        //System.out.println(htDay);
        //System.out.println(htDay.get("TUE"));
    }
}


