package net.callmeike.android.demo.concurrent.puzzlers;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


public class ResourceLoader {
    private static final Map<String, String> pages = new HashMap<String, String>();

    static synchronized String getPage(String url) {
        String page = pages.get(url);
        if (null != page) { return page; }
        
        try {
            URLConnection con = new URL(url).openConnection();
            page = (String) con.getContent();
        }
        catch (IOException e) { }

        pages.put(url, page);
        return page;
    }

    public static void main(final String[] args) {
        for (int i = 0; i < args.length; i++) {
            final int n = i;
            new Thread(new Runnable() {
                @Override public void run() { getPage(args[n]); }
            } );
        }
    }
}
