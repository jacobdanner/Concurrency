package net.callmeike.android.demo.concurrent.puzzlers;

public class WaitASecII {
    static final char[] foo = new char[0];
    static boolean done;

    public static void main(String[] args) {
        final long stopTime = System.currentTimeMillis() + 1000;

        new Thread(
            new Runnable() {
                @Override public void run() {
                    for (;;) {
                        synchronized (foo) {}
                        done = System.currentTimeMillis() > stopTime;
                    }
                }
            }
        ).start();
        
        for ( ; !done; ) { synchronized (foo) {}; }
        System.exit(0);
    }
}
