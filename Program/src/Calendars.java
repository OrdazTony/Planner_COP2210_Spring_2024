import java.util.Date;
import java.util.GregorianCalendar;

public class Calendars {
    public static void main(String[] args) {
        System.out.println("Display Date:  ");
        display();
    }
    private int year;
    private int month;
    private int day;
    Calendars(int year, int month, int day) {
        //we can take in numbers for now and then change interface to words
        //because java already has a working calendar class, I will simply be focusing on piggybacking off of it.


    }
    public static void display(){
        GregorianCalendar calendar = new GregorianCalendar();

        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH);
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
        int minute = calendar.get(GregorianCalendar.MINUTE);
        int second = calendar.get(GregorianCalendar.SECOND);

        System.out.println(year + "/" + month + "/" + day + "/" + hour + ":" + minute + ":" + second);

        //however I want a UI so I want the calendar to print like it would full screen.


        int width = 7;
        int height = 6;
        int hold = GregorianCalendar.DAY_OF_MONTH - 2; // offset for array starting at 0 and because we want calendar
        //first day as sunday.
        GregorianCalendar[][] view = new GregorianCalendar[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                view[j][i] = new GregorianCalendar();
                if(hold <= 31) {
                    view[j][i].set(GregorianCalendar.YEAR, month, hold++);
                }else hold = 0;
                int date = view[j][i].get(GregorianCalendar.DATE);
                System.out.print("|\t" + date + "\t\t" + "|");
                //this sort of resembles a calendar
            }
            System.out.println();
        }


    }
}


