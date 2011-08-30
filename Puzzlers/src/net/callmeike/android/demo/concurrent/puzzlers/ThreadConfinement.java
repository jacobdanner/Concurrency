package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ThreadConfinement {
    static final class DropBox<T> {
        private T dropBox;

        public synchronized boolean release(T obj) {
            if (null != dropBox) { return false; }
            dropBox = obj;
            return true;
        }

        public synchronized T seize() {
            T o = dropBox;
            dropBox = null;
            return o;
        }
    }

    private static final class PingPong implements Runnable {
        private final DropBox<List<Calendar>> dropBox;
        private List<Calendar> calendars;
        
        public PingPong(DropBox<List<Calendar>> dropBox) {
            this.dropBox = dropBox;
        }
        
        @Override public void run() {
            while (true) {
                if (null == calendars) { calendars = dropBox.seize(); }
                else if (dropBox.release(calendars)) { calendars = null; }
                
                try { Thread.sleep(100); }
                catch (InterruptedException e) { return; }
            }
        }
    }
  
    public static void main(String[] args) {
        DropBox<List<Calendar>> dropBox = new DropBox<List<Calendar>>();
        
        Calendar myCalendar = new GregorianCalendar();
 
        List<Calendar> calendars = new ArrayList<Calendar>();
        calendars.add(myCalendar);
        
        new Thread(new PingPong(dropBox)).start();
        new Thread(new PingPong(dropBox)).start();
 
        dropBox.release(calendars);
        calendars = null;
        
        // more code here...
   }
}
