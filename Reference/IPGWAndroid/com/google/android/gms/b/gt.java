package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.a;
import java.util.ArrayList;
import java.util.List;

@fd
final class gt {
    final Object a = new Object();
    final List<Runnable> b = new ArrayList();
    boolean c = false;
    private final List<Runnable> d = new ArrayList();

    static void a(Runnable runnable) {
        a.a.post(runnable);
    }

    public final void a() {
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            for (Runnable a : this.d) {
                fm.a(a);
            }
            for (Runnable a2 : this.b) {
                a(a2);
            }
            this.d.clear();
            this.b.clear();
            this.c = true;
        }
    }
}
