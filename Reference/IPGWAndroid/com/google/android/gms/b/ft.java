package com.google.android.gms.b;

import android.content.Context;

final class ft implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ fs b;

    ft(fs fsVar, Context context) {
        this.b = fsVar;
        this.a = context;
    }

    public final void run() {
        synchronized (this.b.b) {
            this.b.d = fs.a(this.a);
            this.b.b.notifyAll();
        }
    }
}
