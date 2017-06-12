package com.alipay.b.g;

import android.content.Context;
import java.util.LinkedList;

public final class a {
    private static a c;
    private static Object d = new Object();
    public Thread a;
    public LinkedList<e> b = new LinkedList();
    private Context e;
    private volatile boolean f = false;

    private a(Context context) {
        this.e = context;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (d) {
            if (c == null) {
                c = new a(context);
            }
            aVar = c;
        }
        return aVar;
    }
}
