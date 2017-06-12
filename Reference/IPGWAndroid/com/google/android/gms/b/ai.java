package com.google.android.gms.b;

import android.content.SharedPreferences;

@fd
public final class ai {
    SharedPreferences a = null;
    private final Object b = new Object();
    private boolean c = false;

    public final <T> T a(ab<T> abVar) {
        synchronized (this.b) {
            if (this.c) {
                return gp.a(new aj(this, abVar));
            }
            T t = abVar.b;
            return t;
        }
    }
}
