package net.callmeike.android.demo.concurrent.puzzlers;
import java.util.HashMap;
import java.util.Map;

public class PairMap<K1, K2, V> {
    private final Map<K1, V> map1 = new HashMap<K1, V>();
    private final Map<K2, V> map2 = new HashMap<K2, V>();
   
    
    public synchronized void put(K1 key1, K2 key2, V val) {
        map1.put(key1, val);
        map2.put(key2, val);
    }
    
    public synchronized V getValue1(K1 key) { return getMap1().get(key); }
    
    public synchronized V getValue2(K2 key) { return getMap2().get(key); }

    private synchronized Map<K1, V> getMap1() { return map1; }

    private synchronized Map<K2, V> getMap2() { return map2; }
    
    // other public and private methods...
}
