package net.callmeike.android.demo.concurrent.puzzlers;

public class LazySingleton {
    public static LazySingleton instance;
    
    public static LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {
                if (null == instance) { instance = new LazySingleton(); }
            }
        }
        return instance;
    }
    
    /// lots of code here...
}
