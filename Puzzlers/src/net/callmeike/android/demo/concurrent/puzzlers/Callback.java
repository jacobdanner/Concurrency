package net.callmeike.android.demo.concurrent.puzzlers;
import net.callmeike.android.demo.concurrent.puzzlers.xtra.Service;

public class Callback {
    public static void main(String[] args) {
        Service svc = new Service();
        new Thread(svc).start();
        
        Callback client = new Callback();
        client.setup(svc);
        
        client.doStuff();
    }

    private int calls;

    void incrCalls() { calls++; }

    private void setup(Service svc) {
        svc.registerHandler(new Service.Handler() {
            @Override public void handleCallback() { incrCalls(); }
        } );
    }

    private void doStuff() {
        // ... do stuff
    }
}
