package com.google.android.gms.b;

import android.content.Context;

@fd
public final class gg {
    static hv a;
    public static final gk<Void> b = new gh();
    private static final Object c = new Object();

    public gg(Context context) {
        a = a(context);
    }

    private static hv a(Context context) {
        hv hvVar;
        synchronized (c) {
            if (a == null) {
                a = d.a(context.getApplicationContext());
            }
            hvVar = a;
        }
        return hvVar;
    }
}
