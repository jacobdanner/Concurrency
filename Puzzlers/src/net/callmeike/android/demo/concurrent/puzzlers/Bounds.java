package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.concurrent.atomic.AtomicInteger;

public class Bounds {
    private AtomicInteger top;
    private AtomicInteger bottom;
    
    public void setBounds(int t, int b) {
        top = new AtomicInteger(t);
        bottom = new AtomicInteger(b);
    }
    
    public boolean checkBounds(int t, int b) {
        return (b >= bottom.get()) && (t <= top.get()); 
    }
}
