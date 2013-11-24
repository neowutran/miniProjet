package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd"); 
    static Calendar calendar;  
    
    public Time(){
         calendar = new GregorianCalendar();
    }
 
    //add one month
    
    public static void addMonth(int nb){
        calendar.add(Calendar.MONTH,nb);
    }
    
    public static void addDay(int nb){
        calendar.add(Calendar.DAY_OF_MONTH,nb);
    }
    public String toString(){
        return "Date : " + sdf.format(calendar.getTime());
    }
}
