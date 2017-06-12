package com.google.android.gms.b;

import android.os.Process;
import com.google.android.gms.ads.internal.f;
import java.util.concurrent.Callable;

final class fp implements Runnable {
    final /* synthetic */ gr a;
    final /* synthetic */ Callable b;

    fp(gr grVar, Callable callable) {
        this.a = grVar;
        this.b = callable;
    }

    public final void run() {
        try {
            Process.setThreadPriority(10);
            this.a.b(this.b.call());
        } catch (Throwable e) {
            f.f().a(e, true);
            this.a.cancel(true);
        }
    }
}
