/* $Id: $
 */
package net.callmeike.android.demo.concurrent.puzzlers.xtra;


/**
 *
 * @version $Revision: $
 * @author <a href="mailto:bmeike@callmeike.net">Blake Meike</a>
 */
public class Service implements Runnable {
    public static interface Handler { void handleCallback(); }
    
    private Handler client;
    
    public synchronized void registerHandler( Handler client) {
        this.client = client;
    }

    @Override public void run() {
        // ...
        doCallback();
    }
    
    private synchronized void doCallback() {
        if (null != client) { client.handleCallback(); }
    }
}