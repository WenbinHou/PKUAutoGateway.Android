package com.google.android.gms.b;

import java.util.concurrent.Future;

final class fq implements Runnable {
    final /* synthetic */ gr a;
    final /* synthetic */ Future b;

    fq(gr grVar, Future future) {
        this.a = grVar;
        this.b = future;
    }

    public final void run() {
        if (this.a.isCancelled()) {
            this.b.cancel(true);
        }
    }
}
