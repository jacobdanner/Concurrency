package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.callmeike.android.demo.concurrent.puzzlers.xtra.PathLogger;

public class Path {
    public static void main(String[] args) {
        Path trek = new Path();
        
        new Thread(new PathLogger(trek)).start();
        
        trek.readGPS();
    }

    public final class Waypoint {
        private final long x;
        private final long y;
        private final long arrival;

        public Waypoint(long x, long y, long arrival) {
            this.x = x;
            this.y = y;
            this.arrival = arrival;
            path.add(this);
        }
        
        long getX() { return x; }
        long getY() { return y; }
        long getArrival() { return arrival; }
    }

    final List<Waypoint> path = new ArrayList<Waypoint>();
    private final List<Waypoint> safePath = Collections.unmodifiableList(path);
 
    public List<Waypoint> getPath() { return safePath; }
    
    private void readGPS() {
        // update path with recent GPS coordinates...
    }
}
