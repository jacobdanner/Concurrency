package net.callmeike.android.demo.concurrent.puzzlers;

public class WaitASec {
    static boolean done;

    public static void main(String[] args) {
        final long stopTime = System.currentTimeMillis() + 1000;

        new Thread(
            new Runnable() {
                @Override public void run() {
                    for (;;) {
                        done = System.currentTimeMillis() > stopTime;
                    }
                }
            }
        ).start();
        
        for ( ; !done; ) { }
        System.exit(0);
    }
}
