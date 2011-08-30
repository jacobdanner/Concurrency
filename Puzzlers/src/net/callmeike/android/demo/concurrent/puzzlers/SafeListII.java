package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.List;

public class SafeListII<T> {
    private final List<T> list;

    public SafeListII(List<T> list) { this.list = list; }

    public synchronized void add(T o) { list.add(o); }
    
    public synchronized T get(int i) { return list.get(i); }
}
