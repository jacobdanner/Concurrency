package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import net.callmeike.android.demo.concurrent.puzzlers.xtra.FindBirthdays;
import net.callmeike.android.demo.concurrent.puzzlers.xtra.FindHolidays;

public class SafeList<T> {
    public static void main(String[] args) {
        Calendar myCalendar = new GregorianCalendar();
        
        List<Calendar> calendars = new ArrayList<Calendar>();
        calendars.add(myCalendar);
        calendars = Collections.unmodifiableList(calendars);
        
        new Thread(new FindBirthdays(calendars)).start();
        new Thread(new FindHolidays(calendars)).start();
        
        // lots more code...
    }
}
