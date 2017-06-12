package com.google.android.gms.b;

final class fj implements Runnable {
    final /* synthetic */ fi a;

    fj(fi fiVar) {
        this.a = fiVar;
    }

    public final void run() {
        this.a.c = Thread.currentThread();
        this.a.a();
    }
}
