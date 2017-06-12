package com.google.android.gms.b;

final class au implements Runnable {
    final /* synthetic */ hs a;
    final /* synthetic */ at b;

    au(at atVar, hs hsVar) {
        this.b = atVar;
        this.a = hsVar;
    }

    public final void run() {
        try {
            this.b.d.put(this.a);
        } catch (InterruptedException e) {
        }
    }
}
